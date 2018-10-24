package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestConnection {

    public static void main(String[] args) throws IOException {
        InputStream inStream = TestConnection.class.getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(inStream);
        System.out.println(properties.getProperty("username"));
    }

}
