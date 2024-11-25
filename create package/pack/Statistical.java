package pack;

public class Statistical{
	public static double mean(double[] arr){
		double sum=0;
		if(arr.length==0){
			return -1;
		}
		else{
			for(double i:arr){
				sum+=i;
			}
		}
		return sum/arr.length;
	}
}