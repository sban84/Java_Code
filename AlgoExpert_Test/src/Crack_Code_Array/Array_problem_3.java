package Crack_Code_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PrimitiveIterator.OfInt;

import javax.swing.text.AsyncBoxView.ChildLocator;

public class Array_problem_3 {
	
	public static void main(String args[]) {
		// TODO Auto-generated method stub

		rotateArray();
		
		//splitArrayInKParts(new Integer[] {1,2,3,4,5}, 2);
		
		
		//test();
	}

	public static void rotateArray() {
		int[] array = new int[] {1,2,3,4,5,6};
		int k = 3;
		//List<int[]> list = new ArrayList<int[]>();
		//list = Arrays.asList(array);
		
		//List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
		//Collections.rotate(list, 2);
		//display(list);
		
		/// Rotate logic started :: left -> 1,2,3    right -> 5,6
		int[] left = Arrays.copyOfRange(array, 0, k);
		int[] right = Arrays.copyOfRange(array, k, array.length);
		
		int[] rev_left = reverseArray(left, 0, left.length-1); // 3,2,1
		int[] rev_right = reverseArray(right, 0, right.length-1); // 6,5,4
		int[] combinedArray = new int[array.length];
		int j=0;
		for(int i =0 ; i < rev_left.length ; i++) {
			combinedArray[j] = rev_left[i]; 
			j++;
		}
		
		for(int i =0 ; i < rev_right.length ; i++) {
			combinedArray[j] = rev_right[i];  // // combinedArray - > 3,2,1,6,5,4,
			j++;
		}
		
		
		
		// nor reverse to get the final rotate array 
		int[] rotateResult = reverseArray(combinedArray,0,combinedArray.length-1);
		for(int i=0 ; i < rotateResult.length ; i ++) {
			System.out.print(rotateResult[i] +","); 
		}
	}
	
	public static int[] reverseArray(int[] arr , int start , int end) {
		int[] result = new int[arr.length];
		System.out.println("end " + end);
		int j =0;
		for(int i =end ; i >= start ; i--) {
			result[j] = arr[i]; 
			j++;
		}
		return result;
	}
	// this is not working as of now but idea is correct and can be implemented  .
	public static void splitArrayInKParts(Integer[] array , int chunkSize) {
		int count =0;
		int startIndex =0;
		int endIndex = chunkSize;
		List<Integer[]> listOfArrays = new ArrayList<Integer[]>();
		
		while(startIndex < array.length){
			Integer[] partArray = Arrays.copyOfRange(array, startIndex, 2);
			
			for(int j=0;j < partArray.length ; j++) {
				System.out.print(partArray[j]);
			}
			listOfArrays.add(partArray);

		    startIndex+= chunkSize;
		    endIndex = startIndex + chunkSize;
		    if(startIndex>array.length -1){
		        endIndex = array.length;
		    }
		}
		
		//display(listOfArrays);
		
	}
	
	public static void display(List<Integer[]> listOfArrays) {
		for (Integer[] integer : listOfArrays) {
			for (Integer integer2 : integer) {
				System.out.print(integer2 + ",");
			}
			
		}
	}
	
	public static void test() {
		
		Integer[] a = new Integer[] {1,2,3,4,5};
		
		Integer[] partArray = Arrays.copyOfRange(a, 0, 2);
		
		for(int j=0;j < partArray.length ; j++) {
			System.out.print(partArray[j]);
		}
	}
}
