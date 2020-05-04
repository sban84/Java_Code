package Problem_Array;

import java.util.Random;

public class RandomNoTest {

	public static void main(String[] args) {
		
		Random rand = new Random();
		int result = rand.nextInt(100);
		
		System.out.println("result >> " + result);
		
	}
}
