interface Animal{
	default void sound(){
		System.out.print("Animal sound");

	}
}

interface Car{
	default void sound(){
		System.out.print("Car sound");
	}
}

class Mix implements Animal,Car{
	
}
public class Diamond1{
	public static void main(String[] args){
		Mix m1=new Mix();
		
	}
}


