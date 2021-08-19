package com.codingdojo_calculator;

public class calculator {
	private int numero1;
	private int numero2;
	private String operation;
	
	private int perform;
	
	
	
	public calculator() {
		super();
		this.numero1 = numero1;
		this.numero2 = numero2;
	}
	
	public void setOperandOne(int numero1) {
		this.numero1=numero1;
		
	}
	public void setOperation(String operation) {
		if(operation=="+") {
			this.operation=operation;
		}else if(operation=="-") {
			this.operation=operation;
		}else {
			System.out.println("Ingrese + ó -");
		}
		
	}
	public void setOperandTwo(int numero2) {
		this.numero2=numero2;
		
	}
	public void performOperation() {
		if(operation=="+") {
			perform=this.numero1+this.numero2;
		}else if(operation=="-") {
			perform=this.numero1-this.numero2;
		}
	}
	public void getResult() {
		System.out.println(perform);
		
	}
	

}
