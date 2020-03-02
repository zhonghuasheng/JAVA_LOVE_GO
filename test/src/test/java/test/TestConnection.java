package test;

import java.io.IOException;
import java.lang.reflect.Field;

public class TestConnection {

    public static void main(String[] args) throws IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
/*        InputStream inStream = TestConnection.class.getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(inStream);
        System.out.println(properties.getProperty("username"));
*/

        Integer a = 1;
        Integer b =2;
        a = 3;
        swap(a, b);
        System.out.println(a + " vs " + b);
    }

    private static void swap(Integer a, Integer b) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        int temp = a.intValue();
        Field field = Integer.class.getDeclaredField("value");
        field.setAccessible(true);
        field.setInt(a, b);
        field.setInt(b, temp);
    }

}
