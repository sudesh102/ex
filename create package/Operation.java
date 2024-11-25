import pack.Arithmatic;
import pack.Statistical;
import pack.Trigonometric;
public class Operation{
	public static void main(String[] args){
		System.out.print("Arithmatic operation");

		float add=Arithmatic.add(3f,5f);
		System.out.print("\nThe Adddition is:"+add);
		float sub=Arithmatic.sub(3f,5f);
		System.out.print("\nThe Substraction is:"+sub);
		float mul=Arithmatic.mul(3f,5f);
		System.out.print("\nThe Multiplication is:"+mul);
		float div=Arithmatic.div(3f,5f);
		System.out.println("\nThe Division is:"+div);

		System.out.println("\nStatistical operation");

		double[] arr={1,2,3,4,5,6,7,8,9,10};
		System.out.print("\nThe Mean is:"+Statistical.mean(arr));
		
		System.out.println("\nTrigonometric operation");
		System.out.println("Sine of 30 degrees: " + Trigonometric.sine(30));
        	System.out.println("Cosine of 30 degrees: " + Trigonometric.cosine(30));
        	System.out.println("Tangent of 30 degrees: " + Trigonometric.tangent(30));
	}
}