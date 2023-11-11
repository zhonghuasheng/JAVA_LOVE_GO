package com.zhonghuasheng.basic.java.util.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AbstractListExample {

    public static void main(String[] args) {
        List<String> values = new ArrayList<String>();
        values.add("a");
        values.add("b");
        values.add("c");
        values.add("d");

        // list.remove()导致modCount改变，会引发ConcurrentModificationException
/*        for (String value : values) {
            if ("b".equals(value)) {
                values.remove(value);
            }
        }*/

        Iterator<String> iterators = values.iterator();
        while (iterators.hasNext()) {
            System.out.println(iterators.next());
            if ("b".equals(iterators.next())) {
                iterators.remove();
            }
        }
    }

}
