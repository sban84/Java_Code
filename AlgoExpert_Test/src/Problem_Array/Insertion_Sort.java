package Problem_Array;

import java.util.Arrays;

public class Insertion_Sort {
	
	public static void main(String[] args) {
		insertion_sort(new int[] {8,5,2,9,5,6,3});
	}
	

	public static int[] insertion_sort(int[] array) {
		
		if(array.length ==0) {
			return new int[] {};
		}
		for(int j=1 ; j < array.length; j++) {
			for(int i=0 ; i < j ; i++) {
				
				
				if(array[i] > array[j]) {
					
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		
		return array;
		
		/*System.out.println("after insertion sort " );
		for (int i : array) {
			System.out.print(i +",");
			
		}*/
	}
}
