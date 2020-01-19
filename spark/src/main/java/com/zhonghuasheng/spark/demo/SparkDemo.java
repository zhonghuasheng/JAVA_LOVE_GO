package com.zhonghuasheng.spark.demo;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;

import java.util.ArrayList;
import java.util.List;

public class SparkDemo {

    private static String appName = "spark.demo";
    private static String master = "local[*]";

    public static void main(String[] args) {
        // 初始化JavaSparkContext
        SparkConf conf = new SparkConf().setAppName(appName).setMaster(master);
        JavaSparkContext sc = new JavaSparkContext(conf);
        // 生成数据源
        List<Student> data = new ArrayList<Student>();
        for (int i = 0; i < 10000; i++) {
            boolean gaoKao = i % 2 == 0;
            String sex = i % 3 == 0 ? "男" : "女";
            String name = "A";
            data.add(new Student(gaoKao, sex, name, i));
        }
        // 生成RDD
        JavaRDD<Student> rdd = sc.parallelize(data);
        // 过滤符合条件的数据
        JavaRDD<Student> jrdd = rdd.filter(new Function<Student, Boolean>() {
            public Boolean call(Student student) throws Exception {
                // 过滤数据
                return student.getAge() > 5000;
            }
        });
        // map && reduce
        Student result = jrdd.map(new Function<Student, Student>() {
            public Student call(Student student) throws Exception {
                student.setCount(1);
                return student;
            }
        }).reduce(new Function2<Student, Student, Student>() {
            public Student call(Student student, Student student2) throws Exception {
                student.setCount(student.getCount() + student2.getCount());
                return student;
            }
        });

        System.out.println("执行结果： " + result.getCount());
    }
}
