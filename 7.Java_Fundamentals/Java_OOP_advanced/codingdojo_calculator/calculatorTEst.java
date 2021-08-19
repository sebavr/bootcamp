package com.codingdojo_calculator;

public class calculatorTEst {

	public static void main(String[] args) {
		
		calculator c= new calculator();
		c.setOperandOne(1);
		c.setOperation("-");
		c.setOperandTwo(2);
		c.performOperation();
		c.getResult();
		
		

	}

}
