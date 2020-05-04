package Crack_Code_Array;

import java.math.BigInteger;

public class Array_problem_2 {

	public static void main(String[] args) {
		reverseANum(1234);
		int result = getNthFibo(6);
		System.out.println(" result " + result );
		System.out.println("factorial " + factorial(4));
		power(2,100);
		isPrime(7);
	}
	
	public static void reverseANum(int num) {
		int result = 0;
		// 1234
		while(num > 0) {
			int div = num % 10; //4
			result = result *10 + div;
			num = num / 10;
		}
		System.out.println(" reverse " + result);
	}
	
	public static int getNthFibo(int n) {
		if(n ==1) return 0;
		else if(n ==2) return 1;
		else {
			return getNthFibo(n-2) + getNthFibo(n-1);
		}
	}
	
	public static int factorial(int num) {
		if(num <= 1) return 1;
		else {
			return num * factorial(num -1 );
		}
	}
	
	//https://www.geeksforgeeks.org/writing-power-function-for-large-numbers/
	public static void power(int a, int b) {
		BigInteger result = new BigInteger("1");
		for(int i=0 ; i < b ; i++) {
			result = result.multiply(BigInteger.valueOf(a));
		}
		System.out.println("power " + result);
	}
	
	static boolean ispowerof2 ( long num ) 
	{ 
	    if ((num & (num - 1)) == 0) // yes // e.g 100 & 011 = 0 ,
	        return true; 
	    return false;  
	} 
	public static void isPrime(int num) {
		boolean isPrime = true;
		for(int i = 2; i< num ; i++) {
			if(num % i ==0) {
				System.out.println("Not a prime ");
				isPrime = false;
				break;
			}
			
		}
		if(isPrime )
		System.out.println("A prime ");
	}
}
