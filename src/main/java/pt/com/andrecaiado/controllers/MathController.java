package pt.com.andrecaiado.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pt.com.andrecaiado.converters.NumberConverter;
import pt.com.andrecaiado.exceptions.UnsupportedMathOperationException;
import pt.com.andrecaiado.math.SimpleMath;

@RestController
public class MathController {
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		return SimpleMath.sum(numberOne, numberTwo);
	}
	
	@RequestMapping(value="/subtraction/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		return SimpleMath.substraction(numberOne, numberTwo);
	}
	
	@RequestMapping(value="/multiplication/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mult(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		return SimpleMath.multiplication(numberOne, numberTwo);
	}
	
	@RequestMapping(value="/division/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		return SimpleMath.division(numberOne, numberTwo);
	}
	
	@RequestMapping(value="/mean/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		return SimpleMath.mean(numberOne, numberTwo);
	}
	
	@RequestMapping(value="/squareRoot/{number}", method=RequestMethod.GET)
	public Double raiz(@PathVariable("number") String number) throws Exception {
		return SimpleMath.squareRoot(number);
	}
}
