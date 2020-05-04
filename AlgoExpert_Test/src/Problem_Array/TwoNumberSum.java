package Problem_Array;

import java.util.Arrays;

public class TwoNumberSum {
	
	public static void main(String[] args) {
		//int array[] =  {3,5,-4,8,11,-1,1,6}; a+b =k , a-k = -b => { }
		int[] array = {-21, 301, 12, 4, 65, 56, 210, 356, 9, -47};
		int[] result = FindPairTwoNumberSum(array , 164);
		System.out.println(result);
		
		System.out.println(Arrays.equals(result, new int[] {}));
				
		display(result);
	}
	
	private static int[] FindPairTwoNumberSum(int[] array, int target) {
		Arrays.sort(array);
		int[] pair = new int[2];
		boolean pairExist = false;
		for(int i=0,  j = array.length -1 ; i< j; ) {
			//int j = array.length -1 ;
			
			if(array[i] + array[j] == target) {
				pair[0] = array[i];
				pair[1] = array[j];
				pairExist = true;
			}
			if(array[i] + array[j] < target) {
				i++;
			}
			else {
				j--;
			}
		}
		
		if(pairExist) {
			return pair;
		}
		
		else {
			return new int[]{};
		}
	}
		
	private static void display(int[] array) {
		for(int i =0;i < array.length ; i++) {
			System.out.println("pair " +array[i]);
		}
	}

}


