/**
 * Class: ResultCalculateSale.java
 * 
 * @since 5/07/2024
 * @version 0.1
 * @author Ing. Jhon Jaime Mendez
 * @copyrigth JASOFT
 **/


package edu.cecar.concurencia;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class ResultCalculateSale {
	
	private static BigDecimal result = BigDecimal.ZERO;
	private static BigDecimal averageSales = BigDecimal.ONE;
	
	private static long numberSales;
	
	private static Map<Integer,BigDecimal> salesByYear = new HashMap<Integer, BigDecimal>();
	
	public static BigDecimal getResult() {
		return result;
	}
	
	public static long getNumberSales() {
		return numberSales;
	}
	
	public static BigDecimal getAverageSales() {
		return averageSales;
	}
	
	public static Map<Integer, BigDecimal> getSalesByYear() {
		return salesByYear;
	}
	
	public static void addValue(String value) {
		
		result = result.add(new BigDecimal(value));
	}

	
	public static void countSales() {
		
		numberSales++;
	}
	
	
	public static void addSalesByYear(Integer year, String value) {
		
		BigDecimal valueDecimal = new BigDecimal(value);
		
		
		if (salesByYear.containsKey(year))
			
			salesByYear.put(year, salesByYear.get(year).add(valueDecimal));
		
		else
			
			salesByYear.put(year, valueDecimal);
		
	}
	
	
    public static void calculateAverage() {
		
    	averageSales = result.divide(BigDecimal.valueOf(numberSales), RoundingMode.CEILING);
	}
}
