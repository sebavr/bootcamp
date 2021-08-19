package com.codingdojo_calculator;

public class calculatorTEst {

	public static void main(String[] args) {
		
		calculator c= new calculator();
		c.performOperation(10.5);
		c.performOperation("+");
		c.performOperation(5.2);
		c.performOperation("*");
		c.performOperation(10);
		c.performOperation("=");
		c.getResults();
		
		

	}

}
