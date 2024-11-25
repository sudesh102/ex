interface Disel{
	public void start();
}

interface Sedan{
	public void start();
}

class Car implements Disel,Sedan{
	public void start(){
		System.out.print("Car Started!!!");
	}
}
public class Diamond{
	public static void main(String[] args){
		Car c1=new Car();
		c1.start();
	}
}