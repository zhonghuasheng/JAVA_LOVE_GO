package com.zhonghuasheng.basic.java.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;


public class FileExample {

    public static void main(String[] args) {
        // 读取文件
        try {
            BufferedReader br = new BufferedReader(new FileReader("E:\\code\\JAVA\\basic\\src\\main\\java\\com\\zhonghuasheng\\basic\\java\\io\\test.log"));
            String str;
            // br.readLine()是一次读取一行
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 写文件
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\code\\JAVA\\basic\\src\\main\\java\\com\\zhonghuasheng\\basic\\java\\io\\write.log"));
            bw.write("hello");
            bw.newLine();
            bw.write("world");
            bw.append("!!!");
            // bw.flush(); // close会自动flush
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File("E:\\code\\JAVA\\basic\\src\\main\\java\\com\\zhonghuasheng\\basic\\java\\io\\");
        File[] files = file.listFiles(new FilenameFilter() {
            
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });

        for (File f : files) {
            System.out.println(f.getName());
        }
    }
}
