package com.dong.util;

import java.util.ArrayList;
import java.util.Arrays;

public class ConvertStringArrayList {

	public static void main(String[] args) {
		String str = "1,2,3,4,5";
		ArrayList<String>arrayList = new ArrayList<String>();
		arrayList = stringToArrayList(str);
		System.out.println(arrayList);
		str = ArrayListToString(arrayList);
		System.out.println(str);
	}
	
	
	/**
	 * Convert ","separated String to ArrayList
	 * @param str
	 * @return
	 */
	public static ArrayList<String> stringToArrayList(String str){
		
		ArrayList<String>strValueList = new ArrayList<String>(Arrays.asList(str.split(",")));
		return strValueList;
	}
	
	
	/**
	 * Convert ArrayList to ","separated String
	 * @param list
	 * @return
	 */
	public static String ArrayListToString(ArrayList<String>list){
		
		String result = null;
		StringBuilder sb = new StringBuilder();
		for(String s : list){
			sb.append(s + ",");
			result = sb.toString();
		}
		
		if(result.length() > 0 && result.charAt(result.length()-1) == ','){
			result = result.substring(0,result.length()-1);
		}
		return result;
		
	}

}
