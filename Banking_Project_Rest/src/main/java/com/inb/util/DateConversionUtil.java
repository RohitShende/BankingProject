package com.inb.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.inb.mongo.collections.BranchManager;

public class DateConversionUtil {
	
	public static Date changeDateFormat(BranchManager branchManager)
	{
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(branchManager.getDateOfBirth());
		Calendar calendar2=new GregorianCalendar(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)+1);
		Date isoDate=calendar2.getTime();
		return isoDate;
	}
}
