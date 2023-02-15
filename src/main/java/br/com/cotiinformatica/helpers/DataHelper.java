package br.com.cotiinformatica.helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DataHelper {

	// método para formar e retornar uma data JAVa como yyy-MM-dd

	public static String formatData(Date data) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		return simpleDateFormat.format(data);
	}

	public static Date formatToDate(String date) {
		
		int ano = Integer.parseInt(date.substring(0, 4));
		int mes = Integer.parseInt(date.substring(5, 7));
		int dia = Integer.parseInt(date.substring(8, 10));

		Calendar calendar = new GregorianCalendar(ano, mes - 1, dia);

		return calendar.getTime();
	}
}
