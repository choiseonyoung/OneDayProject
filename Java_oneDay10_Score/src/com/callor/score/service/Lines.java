package com.callor.score.service;

public class Lines {

	public static String dLine(int nCount) {
		String dLine = String.format("%0" + nCount + "d", 0).replace("0", "=");

		return dLine;
	}

	public static String sLine(int nCount) {

		return String.format("%0" + nCount + "d", 0).replace("0", "-");
	}

}
