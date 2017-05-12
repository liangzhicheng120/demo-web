package com.xinrui.demo.util.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MapUtil {

	public static Map<Integer, Double> SortByValue(Map<Integer, Double> map) {
		List<Map.Entry<Integer, Double>> list = new ArrayList<Map.Entry<Integer, Double>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Double>>() {
			public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
				return (o1.getValue().compareTo(o2.getValue()));
			}
		});
		return map;
	}

	public static List<Integer> MapKeyToList(Map<Integer, Double> map) {
		List<Integer> key = new ArrayList<Integer>();
		Iterator<Integer> it = SortByValue(map).keySet().iterator();
		while (it.hasNext()) {
			key.add(it.next());
		}
		return key;
	}
}
