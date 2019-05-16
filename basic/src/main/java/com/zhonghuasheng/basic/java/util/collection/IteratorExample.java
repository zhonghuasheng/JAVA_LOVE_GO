package com.zhonghuasheng.basic.java.util.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {

    public static void main(String[] args) {
        List<String> values = new ArrayList<String>();
        values.add("a");
        values.add("b");
        values.add("c");

        Iterator<String> iterators = values.iterator();
        /* 这里调用会报错 IllegalStateException - if the next method has not yet been called,
        or the remove method has already been called after the last call to the next method
        */
        // iterators.remove();

        while (iterators.hasNext()) {
            System.out.println(iterators.next());
            iterators.remove();
        }
    }

}
