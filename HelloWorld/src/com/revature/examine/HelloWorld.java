package com.revature.examine;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println("hello World");
			
			//create instance of calculator class
			Calculator calc= new Calculator();
			System.out.println(calc.toString());
			double Addresult= calc.add(26, 13);
			System.out.println("26 plus 13 is: "+Addresult);
			String s="5";
			Double d= Double.parseDouble(s);
			System.out.println(d.getClass());
			
	}

}
