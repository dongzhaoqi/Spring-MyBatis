package com.dong.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtils {

	public static void main(String[] args) {
		String str = "1,2,3,4,5";
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList = stringToArrayList(str);
		System.out.println(arrayList);

		str = ArrayListToString(arrayList);
		System.out.println(str);

		readFileToConsole("D:/logs/2016-01-08.log");

		readConsoleToFile("D:/logs/test.log");
	}

	/**
	 * 1.
	 * Convert ","separated String to ArrayList
	 * 将逗号分隔的字符串转换成数组
	 * @param str
	 * @return
	 */
	public static ArrayList<String> stringToArrayList(String str) {

		ArrayList<String> strValueList = new ArrayList<String>(
				Arrays.asList(str.split(",")));
		return strValueList;
	}

	/**
	 * 2.
	 * Convert ArrayList to ","separated String
	 * 将数组转换成逗号分隔的字符串
	 * @param list
	 * @return
	 */
	public static String ArrayListToString(ArrayList<String> list) {

		String result = null;
		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			sb.append(s + ",");
			result = sb.toString();
		}

		if (result.length() > 0 && result.charAt(result.length() - 1) == ',') {
			result = result.substring(0, result.length() - 1);
		}
		return result;
	}

	/**
	 * 3.
	 * Read local file to console
	 * 读取本地文件并输出到控制台
	 * @param filePath
	 * @date 2016-1-12
	 */
	public static void readFileToConsole(String filePath) {

		File file = new File(filePath);
		if (!file.exists()) {
			System.out.println("文件" + file.getAbsolutePath() + "不存在");
			return;
		}
		try {
			InputStream inputStream = new FileInputStream(file);
			byte buffer[] = new byte[(int) file.length()];
			inputStream.read(buffer);
			System.out.println("result:" + new String(buffer));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 4.
	 * Read concole content to file
	 * 读取控制台输入的内容并写入到文件
	 * @param filePath
	 * @date 2016-1-12
	 */
	public static void readConsoleToFile(String filePath) {
		File file = new File(filePath);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("文件" + file.getAbsolutePath() + "已创建");
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			String content = reader.readLine();
			OutputStream outputStream = new FileOutputStream(file);
			outputStream.write(content.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 5.
	 * 判断字符串是否为数字
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	/**
	 * 6.
	 * 获取文件后缀名
	 * @param filename
	 * @return
	 */
	public static String getExtensionName(String filename) {
		if ((filename != null) && (filename.length() > 0)) {
			int dot = filename.lastIndexOf('.');
			if ((dot > -1) && (dot < (filename.length() - 1))) {
				return filename.substring(dot + 1);
			}
		}
		return filename;
	}

}