package com.zac.util;

import java.text.DecimalFormat;

public class MoneyUtil {

	/*
	 * myMoney is the input String returnString is the output String
	 */
	static String[] Chinese = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };

	static String[] Unit = { "亿", "仟", "佰", "拾", "万", "仟", "佰", "拾", "圆", "角", "分" };

	String myMoney = null;

	String returnString = null;

	public MoneyUtil(double s) {
		DecimalFormat df = new DecimalFormat("0.00");//最多保留几位小数，就用几个#，最少位就用0来确定   
		myMoney = df.format(s);
	}

	public boolean check() {
		double temp = 0.0;
		try {
			temp = Double.parseDouble(myMoney);

		} catch (NumberFormatException e) {
			return false;
		}
		if (temp < 0.0 || temp >= 1000000000.0) {
			return false;
		}
		return true;
	}

	public String getString() {
		return myMoney;
	}

	public boolean zeroCheck(int i, int[] numMoney) {
		boolean temp = false;
		for (int j = i; j <= 8; j++)
			if (numMoney[i] > 0)
				temp = true;
		return temp;

	}
	
	public String convert(int tmp) {
		boolean[] tempMark = { false, false, false, false, false, false, false, false, false, false, false };
		int[] numMark = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		// first get the index of '.'
		int index = myMoney.indexOf(".");
		int indexMark = index;
		if (index == -1)
			index = myMoney.length();
		// the intpart of the money
		String firstPart = myMoney.substring(0, index);
		// the floatPart of the money
		String lastPart = null;
		if (indexMark != -1)
			lastPart = myMoney.substring(index + 1, myMoney.length());
		else
			lastPart = "0";

		if (lastPart.length()>2) lastPart = lastPart.substring(0, 2);
		int intPartMoney = Integer.parseInt(firstPart);
		int tempIntPartMoney = intPartMoney;
		for (int i = 0; i <= 8; i++) {
			numMark[i] = tempIntPartMoney / (int) Math.pow(10, (8 - i));
			tempIntPartMoney -= numMark[i] * (int) Math.pow(10, (8 - i));

		}
		numMark[9] = Integer.parseInt(lastPart.substring(0, 1));
		if (lastPart.length() > 1)
			numMark[10] = Integer.parseInt(lastPart.substring(1, 2));
		for (int i = 0; i <= 10; i++) {
			if (numMark[i] != 0)
				tempMark[i] = true;
		}
		returnString = "";
		for (int i = 0; i <= 8; i++) {
			if (numMark[i] != 0)
				returnString = returnString + Chinese[numMark[i]] + Unit[i];
			if (i >= 1 && numMark[i - 1] > 0 && numMark[i] == 0 && zeroCheck(i, numMark) == true)
//			if (i >= 1 && numMark[i - 1] == 0 &&  zeroCheck(i, numMark) == true)
				returnString = returnString + "零";
		}
		if (numMark[8] == 0) {
			returnString = returnString + "圆";
		}
		if (numMark[9] != 0) {
			returnString = returnString + Chinese[numMark[9]] + Unit[9];
		}
		if (numMark[10] != 0) {
			returnString = returnString + Chinese[numMark[10]] + Unit[10];
		}
		if (numMark[9] + numMark[10] == 0)
			returnString += "整";
		return returnString;
	}		

	public String convert() {
		return digitUppercase(Double.parseDouble(myMoney));
	}
	/**
	 * 数字金额大写转换
	 * 要用到正则表达式
	 */
	public static String digitUppercase(double n){
		String fraction[] = {"角", "分"};
	    String digit[] = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
	    String unit[][] = {{"元", "万", "亿"},{"", "拾", "佰", "仟"}};

	    String head = n < 0? "负": "";
	    n = Math.abs(n);
	    
	    String s = "";
	    for (int i = 0; i < fraction.length; i++) {
	        s += (digit[(int)(Math.floor(n * 10 * Math.pow(10, i)) % 10)] + fraction[i]).replaceAll("(零.)+", "");
	    }
	    if(s.length()<1){
		    s = "整";	
	    }
	    int integerPart = (int)Math.floor(n);

	    for (int i = 0; i < unit[0].length && integerPart > 0; i++) {
	        String p ="";
	        for (int j = 0; j < unit[1].length && n > 0; j++) {
	            p = digit[integerPart%10]+unit[1][j] + p;
	            integerPart = integerPart/10;
	        }
	        s = p.replaceAll("(零.)*零$", "").replaceAll("^$", "零") + unit[0][i] + s;
	    }
	    return head + s.replaceAll("(零.)*零元", "元").replaceFirst("^[负]?(零.)+", "").replaceAll("(零.)+", "零").replaceAll("^整$", "零元整");
	}

	public static void main(String[] args) {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String inputString = null;
//		try {
//			inputString = in.readLine();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		inputString = "204010.00";
		MoneyUtil convertor = new MoneyUtil(Double.parseDouble(inputString));
		if (convertor.check() == false) {
			System.out.println("输入数据格式只能为0-10亿之间的数字");
			return;
		}
		
//		System.out.println("------------"+digitUppercase(100100.50));
		System.out.println(convertor.convert());

	}
}
