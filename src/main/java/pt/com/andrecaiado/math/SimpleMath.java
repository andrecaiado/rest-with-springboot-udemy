package pt.com.andrecaiado.math;

import pt.com.andrecaiado.converters.NumberConverter;
import pt.com.andrecaiado.exceptions.UnsupportedMathOperationException;

public class SimpleMath {

	public static Double sum(String numberOne, String numberTwo) {
		if ( !NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo) ) {
			throw new UnsupportedMathOperationException("Please set numeric values!");
		}
		Double res = NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo);
		return res;
	}
	
	public static Double substraction(String numberOne, String numberTwo) {
		if ( !NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo) ) {
			throw new UnsupportedMathOperationException("Please set numeric values!");
		}
		Double res = NumberConverter.convertToDouble(numberOne) - NumberConverter.convertToDouble(numberTwo);
		return res;
	}
	
	public static Double multiplication(String numberOne, String numberTwo) {
		if ( !NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo) ) {
			throw new UnsupportedMathOperationException("Please set numeric values!");
		}
		Double res = NumberConverter.convertToDouble(numberOne) * NumberConverter.convertToDouble(numberTwo);
		return res;
	}
	
	public static Double division(String numberOne, String numberTwo) {
		if ( !NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo) ) {
			throw new UnsupportedMathOperationException("Please set numeric values!");
		}
		Double res = NumberConverter.convertToDouble(numberOne) / NumberConverter.convertToDouble(numberTwo);
		return res;
	}
	
	public static Double mean(String numberOne, String numberTwo) {
		if ( !NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo) ) {
			throw new UnsupportedMathOperationException("Please set numeric values!");
		}
		Double res = (NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo))/2;
		return res;
	}
	
	public static Double squareRoot(String number) {
		if ( !NumberConverter.isNumeric(number) ) {
			throw new UnsupportedMathOperationException("Please set numeric value!");
		}
		Double res = Math.sqrt(NumberConverter.convertToDouble(number));
		return res;
	}
}
