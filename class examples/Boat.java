public class Boat extends Vehicle{




public Boat(int yearmade, String model, String make){

System.out.println("makin a boat");
this.yearMade=yearmade;
this.model=model;
this.make=make;
	}



private int yearMade;
private String model;
private String make;

public void getYear(){
System.out.println((this.yearMade)+","+(this.model)+","+(this.make));
}

@Override

public void move()
{
 System.out.println("oh dang look at that boat move");
}
}
