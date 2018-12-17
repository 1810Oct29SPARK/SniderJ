package com.revature.examine;

public class ControlFlow {

	public static void main(String[] args) {
		
		ifStatements(10,6);
		forLoops();
		whileLoops();
		switchCases();
	}
	
	static void ifStatements(double a, double b)
	{
		if(a >b)
		{
			System.out.println("a is greater than b");
		}
		else if(a ==b)
		{
			System.out.println("a is equal to b");
		}
		else
		{
			System.out.println("a is less than b");
		}
	}
	
	static void forLoops()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println(i);
		}
		System.out.println("even numbers: ");
		for(int j=0;;j++)
		{
			
			if (j%2!=0)
			{
				continue;
			}
			System.out.println(j);
			if (j==20)
			{
				break;
			}
		}
	}
	
	static void whileLoops()
	{
		int i=0;
		while(true)
		{
			System.out.println(i);
			i+=1;
			if(i>15)
			{
			break;
			}
		}
		
		do {
			System.out.println("do-wop block runs before condition is checked");
		} while (false);
	}
	
	
	static void switchCases()
	{
		String dayOfWeek="AAAAAH";
		switch(dayOfWeek) 
		{
		case "Sunday":
			System.out.println("today is Sunday");
			break;
		
		case "Monday":
			System.out.println("today is Monday");
			break;
			
		case "Tuesday":
			System.out.println("today is Tuesday");
			break;
			
		case "Wednesday":
			System.out.println("today is Wednesday");
			break;
		
		case "Thursday":
			System.out.println("today is Thursday");
			break;
			
		case "Friday":
			System.out.println("today is Friday");
			break;
			
		case "Saturday":
			System.out.println("today is Saturday");
			break;
			
		default:
			System.out.println("today is nuts man!");
		
		
		}
	}
}
