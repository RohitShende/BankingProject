package com.inb.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.inb.rest.entity.BranchManagerPOJO;

public class DateConversionUtil {
	
	public static Date changeDateFormat(BranchManagerPOJO branchManager)
	{
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(branchManager.getDateOfBirth());
		Calendar calendar2=new GregorianCalendar(calendar.get(calendar.YEAR),calendar.get(calendar.MONTH),calendar.get(calendar.DAY_OF_MONTH)+1);
		Date isoDate=calendar2.getTime();
		return isoDate;
	}
}
