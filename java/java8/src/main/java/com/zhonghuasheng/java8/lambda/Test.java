package com.zhonghuasheng.java8.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        List<People> people = new ArrayList<People>();
        people.add(new People("ax", 12));
        people.add(new People("sb", 13));
        people.add(new People("cd", 14));
        people.add(new People("dd", 15));
        people.add(new People("ee", 16));
        people.add(new People("fd", 17));

        Collections.sort(people, (p1, p2)-> p1.getName().compareTo(p2.getName()));
        people.forEach(p -> System.out.println(p.getName()));
    }
}
