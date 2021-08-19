package com.codingdojo.mostrarfecha;

import java.text.SimpleDateFormat;
import java.util.Date;

public class date_time {
	
	
	
	
	public String showDate() {
		Date d = new Date( );
		SimpleDateFormat dateformat=new SimpleDateFormat ("EEEE, dd 'de' MMMM, yyyy");
		return  dateformat.format(d);
	}
	
	public String showTime() {
		Date t = new Date( );
		SimpleDateFormat dateformat=new SimpleDateFormat ("hh:mm zz");
		return  dateformat.format(t);
	}

}
