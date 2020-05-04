package Problem_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * THis is very good algo to compare items between 2 array , 
 * Step 1 Sort them 
 * step 2 then run for loop and check items.
 * 
 * Here we need to find the 2 item which has min difference between items of the 2 array , 
 */
public class Smallest_diff {
	public static void main(String[] args) {
		
		
		findSmallestDiff(new int[] {-1,5,10,20,28,30}, new int[] {26,134,135,15,17});
		
		findSmallestDiff_optimized(new int[] {-1,5,10,20,28,30,17}, new int[] {26,134,135,15,17});
	}
	
	//O(nlogn ) and O(n)
	public static void findSmallestDiff_optimized(int[] arrayOne, int[] arrayTwo) {
		Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);
		
		List<int[]> result = new ArrayList<int[]>();
		int[] single_pair = new int[2];
		int current_diff = Integer.MAX_VALUE;
		int min_diff = Integer.MAX_VALUE;
		
		for(int i =0, j=0; i < arrayOne.length && j < arrayTwo.length; ) {
			int first = arrayOne[i];
			int sec = arrayTwo[j];
			if(first < sec) {
				current_diff= sec - first;
				i++;
			}
			else if(sec < first) {
				current_diff= first - sec;
				j++;
			}
			else if (sec == first) {
				current_diff= first - sec;
				i++;
				j++;
				System.out.println("item matched >> "+ first + " and " + sec);
			}
			if(current_diff < min_diff) {
				min_diff = current_diff;
				single_pair[0] = first;
				single_pair[1] = sec;
			}
		}
		result.add(single_pair);
		System.out.println("single_pair >> "+ single_pair[0] + " and " + single_pair[1]);
	}
	
	public static int[] findSmallestDiff(int[] arrayOne, int[] arrayTwo){
		int min_diff = Integer.MAX_VALUE;
		
		int first_pair  = 0;
		int sec_pair = 0;
		for(int i=0 ; i< arrayOne.length ; i++) {
			int first = arrayOne[i];
			for(int j=0;j<arrayTwo.length;j++) {
				int sec = arrayTwo[j];
				int diff = Math.abs(first -sec) ;
				if(diff < min_diff ) {
					min_diff = diff;
					
					first_pair = first;
					sec_pair = sec;
					//break;
				}
			}
		}
		return new int[] {first_pair,sec_pair};
		//System.out.println("pair " + first_pair + " & " + sec_pair);
		
		
	}

}
