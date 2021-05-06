package com.lab.exercise;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GroupAnagrams {

	public static void main(String[] args) {
		String[] words = { "abc", "bca", "tax", "pims", "mat", "atm", "xat", "simp" };

		List<String> sortedStrings = new ArrayList<String>();
		Map<String, String> groups = new HashMap<>();

		for (String s : words) {
			char[] temp = s.toCharArray();
			Arrays.sort(temp);
			sortedStrings.add(s);
			if (groups.containsKey(new String(temp))) {
				String soFar = groups.get(new String(temp));
				groups.put(new String(temp), soFar + "," + s);
			} else {
				groups.put(new String(temp), s);
			}
			
		}

		for (Entry<String, String> entry : groups.entrySet()) {
			System.out.println(entry.getValue());
		}
	}

}
