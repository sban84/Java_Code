package Problem_Array;

// How recursion works ? this is good to understand 
public class RecursionTest {
	
	public static void main(String args[])
	{
		int result = new RecursionTest().calculateSumUningRecursion(3);
		System.out.println("Sum is " + result);
	}

	int sum =0;
	private  int calculateSumUningRecursion(int n) {
		//int sum =0;
		if(n==0){
			return 0;
		}
		else
		{
			 sum = n + calculateSumUningRecursion(n-1);
			return sum;
		}
	}
}
