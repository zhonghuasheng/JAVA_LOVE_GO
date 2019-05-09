package com.zhonghuasheng.basic.collection.list.arraylist;

import java.util.*;

import com.zhonghuasheng.basic.collection.list.arraylist.model.People;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.iterator;

public class main {

    public static void main(String[] args) {
        People people = new People("test", 12);

        List peopleList1 = new ArrayList();
        peopleList1.add(people);

        List peopleList2 = new ArrayList();
        people.setAge(11);
        peopleList2.add(people);

        System.out.println(peopleList1.equals(peopleList2));

        // get(int index) 说明List是有序的。这里的索引参数是int，因为Collection的最大size是Integer.MAX_VALUE
        peopleList1.get(0);

        // 无序
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("a");
        hashSet.add("b");
        hashSet.add("c");
        hashSet.add("d");
        Iterator iteratorHashSet = hashSet.iterator();

        while (iteratorHashSet.hasNext()) {
            System.out.println(iteratorHashSet.next());
        }

        System.out.println("--华丽分割线--");

        // 有序
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        linkedHashSet.add("a");
        linkedHashSet.add("b");
        linkedHashSet.add("c");
        linkedHashSet.add("d");

        Iterator<String> iterator = linkedHashSet.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // ArrayList扩容
        System.out.println((10 + (10 >> 1))); // 15
        System.out.println((15 + (15 >> 1))); // 22

        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put(null, "a");

        // 避免使用基础数据类型数据转换为列表
        int[] ints = {1, 2, 3, 4, 5};
        List list = Arrays.asList(ints);
        System.out.println("list size: " + list.size()); // list size: 1

        Integer[] ints2 = {1, 2, 3, 4, 5};
        List list2 = Arrays.asList(ints2);
        System.out.println("list2 size: " +  list2.size());
    }

}
