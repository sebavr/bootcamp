package com.codingdojo_phone;

public class PhoneTester {

	public static void main(String[] args) {
		Galaxy s9=new Galaxy("S9",99,"Verizon","Ring! Ring! Ring!");
		Iphone iphoneTen = new Iphone("X",100,"AT&T","Zing!");
		
		s9.displayInfo();
		System.out.println(s9.ring());
		System.out.println(s9.unlock());
		
		iphoneTen.displayInfo();
		System.out.println(iphoneTen.ring());
		System.out.println(iphoneTen.unlock());
		

	}

}
