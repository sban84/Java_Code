package Problem_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumSum {
	
	public static void main(String[] args) {
		
		int[] array = new int[] {12,3,1,2,6,5,-8,-6};
		Arrays.sort(array);
		ThreeNumSumImpl(array, 0);
		
	}
	
	// {12,3,1,2,6,5,-8,6}; => { -8, -6, 1,2,3 , 5,6, 12}
	public static void ThreeNumSumImpl(int[] array , int targetSum) {
		
		List<Integer[]> triplets = new ArrayList<Integer[]>();
		
		for(int i =0; i< array.length -1  ; i++) {
			
			int first_number = array[i];
			for(int j=i+1 , k = array.length-1; j<k; ) {
				//System.out.println(i + ": " + j + ": " + k);
				int left = array[j];
				int right = array[k];
				//System.out.println("before check" + first_number + ": " + left + " : " + right);
				if(first_number + left + right == targetSum) {
					System.out.println("found mathed" + first_number + ": " + left + " : " + right);
					triplets.add(new Integer[] {Integer.valueOf(first_number) , Integer.valueOf(left) , Integer.valueOf(right)});
					j++;
					k--;
				}
				else if(first_number + left + right < targetSum) {
					j++;
				}
				else {
					k --;
				}
				
			}
			
		}
		
		/*for (Integer[] integers : triplets) {
			System.out.println("\n triplets: ");
			for (Integer integer : integers) {
				System.out.print( integer +",");
			}
			
		}*/
		
	}

}
