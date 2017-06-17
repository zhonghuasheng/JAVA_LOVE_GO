package com.zhonghuasheng.basic.collection.list.arraylist;

import java.util.ArrayList;
import java.util.List;

import com.zhonghuasheng.basic.collection.list.arraylist.model.People;

public class main {

    public static void main(String[] args) {
        People people = new People("test", 12);

        List peopleList1 = new ArrayList();
        peopleList1.add(people);

        List peopleList2 = new ArrayList();
        people.setAge(11);
        peopleList2.add(people);

        System.out.println(peopleList1.equals(peopleList2));
    }

}
