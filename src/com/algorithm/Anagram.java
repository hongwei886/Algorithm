package com.algorithm;

import java.util.*;

public class Anagram {

	public static String getAnagramCount(String total, String lookFor) {
		String result = "";
		if (total == null || lookFor == null || total.length() <= 0 || lookFor.length() <= 0
				|| lookFor.length() > total.length()) {
			return result + "0";
		}

		HashMap<String, Integer> lookForMap = new HashMap<String, Integer>();
		for (int x = 0; x < lookFor.length(); x++) {
			char ch = lookFor.charAt(x);
			if (lookForMap.get(Character.toString(ch)) == null) {
				lookForMap.put(Character.toString(ch), new Integer(1));
			} else {
				lookForMap.put(Character.toString(ch),
						new Integer(lookForMap.get(Character.toString(ch)).intValue() + 1));
			}
		}

		int count = 0;
		for (int x = 0; x < total.length(); x++) {
			String checkChar = Character.toString(total.charAt(x));
			if (lookForMap.get(checkChar) != null && lookForMap.get(checkChar).intValue() > 0) {
				HashMap<String, Integer> tempMap = new HashMap<String, Integer>(lookForMap);
				boolean flag = true;
				if (x + lookFor.length() <= total.length()) {
					for (int y = x; y < x + lookFor.length(); y++) {
						String temp = Character.toString(total.charAt(y));
						if (tempMap.get(temp) != null && tempMap.get(temp).intValue() > 0) {
							tempMap.put(temp, tempMap.get(temp).intValue() - 1);
						} else {
							flag = false;
						}
					}
					if (flag) {
						result = result + x + " ";
						count++;
					}
				}
			}

		}
		result = "Total: "+count + " Positions: " + result;
		//System.out.println(lookForMap);
		return result;
	}

	public static void main(String[] ar) {

		System.out.println(getAnagramCount("cbabadcbbabbcbabaabccbabc", "abbc"));
	}

}
