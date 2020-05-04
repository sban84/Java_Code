package Problem_Array;

/*
 * This is best , remember this , it will provide nTh and as well if required we can print all the series also .
 */
public class NthFibo {
	
	public static void main(String[] args) {
		
		int n = 6;
		System.out.println(getNthFib(n)); // o/p = 5
		
		// to print the complete series 
		for(int i=1;i<=n;i++) {
			System.out.print(getNthFib(i) +","); // 0,1,1,2,3,5
		}
	}
	
	private static int getNthFib(int n) {
		if(n ==2 ) return 1;
		else if(n ==1) return 0;
		else {
			return getNthFib(n-2) + getNthFib(n-1); // fib(2)+ fib(1) -> 1 , 0 , 
		}
	}

}
