package com.zac.web.util;

import java.util.*;

import com.zac.web.bean.vo.DateVo;

public class DateUtil {

	public static DateVo[] getMonthDetail(){
		//String[] days = new String[42];
		   /*for (int i = 0; i < 42; i++) {
		    days[i] = "";
		   }*/
		DateVo[] dts=new DateVo[42];
		
		   GregorianCalendar currentDay = new GregorianCalendar();
		   int today = currentDay.get(Calendar.DAY_OF_MONTH);
		   int month = currentDay.get(Calendar.MONTH);
		   int year = currentDay.get(Calendar.YEAR);
		   //out.println(year + "年" + (month + 1) + "月" + today + "日");
		   Calendar thisMonth = Calendar.getInstance();
		   thisMonth.set(Calendar.MONTH, month);
		   thisMonth.set(Calendar.YEAR, year);
		   thisMonth.setFirstDayOfWeek(Calendar.SUNDAY);
		   thisMonth.set(Calendar.DAY_OF_MONTH, 1);
		   int firstIndex = thisMonth.get(Calendar.DAY_OF_WEEK) - 1;
		   int maxIndex = thisMonth.getActualMaximum(Calendar.DAY_OF_MONTH);
		   for (int i = 0; i < maxIndex; i++) {
		    //days[firstIndex + i] = String.valueOf(i + 1);
		    DateVo dtvo=new DateVo();
		    dtvo.setDay(i + 1);
		    dtvo.setColor("RED");
		    if(today==dtvo.getDay()){
		    	dtvo.setToday(true);
		    }
		    dts[firstIndex + i]=dtvo;
		   }
		   
		   return dts;
	}
}
