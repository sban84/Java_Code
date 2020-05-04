package Algorithm_2;

import java.text.DecimalFormat;

/* This is very good example of finding square root without using library.
 * 
 */
public class FindSquareRoot {
	
	public static void main(String args[])
	{
		int number = 15;
		double sqRoot = calculateSquareRoot(number);
		System.out.println("Square root of " + number + " is= " + new DecimalFormat("#.##").format(sqRoot));
		System.out.println("Root Value By InBuild Method Method : " + Math.sqrt(number));
				
	}

	private static double calculateSquareRoot(int number) {
		double squareRoot=number/2;
		
		for(int i= 0;i<number/2;i++)
		{
			squareRoot = (squareRoot+(number/squareRoot))/2;
		}
		
		/*double t;
		double squareRoot = number / 2;
		do {
			t = squareRoot;
			squareRoot = (t + (number / t)) / 2;
		} while ((t - squareRoot) != 0);*/
	 
		return squareRoot;
		
	}
	
	

}

