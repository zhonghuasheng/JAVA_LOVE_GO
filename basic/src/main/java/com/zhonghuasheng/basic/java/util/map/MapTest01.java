package com.zhonghuasheng.basic.java.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest01 {

	public static void main(String[] args) {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("1", "value1");
		hashMap.put("2", "value2");
		hashMap.put("3", "value3");
		
    // key视图
		Set<String> keys = hashMap.keySet();
		Iterator<String> iteratorKeys = keys.iterator();
		while (iteratorKeys.hasNext()) {
			System.out.println(iteratorKeys.next());
		}

    // value视图
		Collection<String> values = hashMap.values();
		Iterator<String> iteratorValues = values.iterator();
		while (iteratorValues.hasNext()) {
			System.out.println(iteratorValues.next());
		}

    // key-value视图
		Set<Entry<String, String>> entrySets = hashMap.entrySet();
		Iterator<Entry<String, String>> iteratorEntrySets = entrySets.iterator();
		while (iteratorEntrySets.hasNext()) {
			Entry<String, String> entry = iteratorEntrySets.next();
			System.out.println(String.format("key: %s, value: %s", entry.getKey(), entry.getValue()));
		}
	}

}
