package com.dong.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class CommonUtils {

	public static void main(String[] args) {
		String str = "1,2,3,4,5";
		ArrayList<String>arrayList = new ArrayList<String>();
		arrayList = stringToArrayList(str);
		System.out.println(arrayList);
		str = ArrayListToString(arrayList);
		System.out.println(str);
		
		
		readFileToConsole("D:/logs/2016-01-08.log");
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
	
	
	/**
	 * Read local file to console
	 * @param filePath
	 */
	public static void readFileToConsole(String filePath){
		
		File file = new File(filePath);
		if(!file.exists()){
			System.out.println("文件"+file.getAbsolutePath()+"不存在");
			return;
		}
		try {
			InputStream inputStream = new FileInputStream(file);
			byte buffer[] = new byte[(int) file.length()];
			inputStream.read(buffer);
			System.out.println("result:"+new String(buffer));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}