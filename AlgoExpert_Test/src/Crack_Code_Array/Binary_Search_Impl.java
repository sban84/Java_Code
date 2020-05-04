package Crack_Code_Array;

import java.util.Arrays;

public class Binary_Search_Impl {

	public static void main(String[] args) {
		int[] array = {5,10,50,2,9,51}; // 2 5 5 5 9 10
	    //int[] array = {1,2,3,4,5,5,6};
	    Arrays.sort(array);
	    System.out.println("array after sorting  ");
	    for (int i : array) {
	    	System.out.print(i + ",");
		}
	    int result = BinarySerach(array, 51, 0, array.length-1);
	    System.out.println("seach found at index " + result );
	    
	    int[] arr = new int[]{3,4,6,1,2,3};
	    int result_1 = searchInCircularArray(arr, 4, 0, array.length-1);
	    System.out.println("Circular Array seach found at index " + result_1 );
	}
	
	public static int BinarySerach(int[] arr, int search , int low , int high) {
		if(low <= high) // <= is must
		{
			//int mid = low + (high -low )/2; 
			//int mid =  (high -low)/2; // does not work
			int mid = (low+high)/2;  // this is same as above 
			if(search == arr[mid])
			{
				//System.out.println("found element " + search + " at " + mid);
				return mid;
			}
			else if(search < arr[mid])
			{
				return BinarySerach(arr, search , low,mid-1);
			}
			else
			{
				return BinarySerach(arr, search , mid+1,high);
			}
		}
		return -1;	
	}
	
	private static int searchInCircularArray(int[] arr , int num,int low,int high) {
		if(low <=high) {
			int mid = low + (high-low)/2;
			if(num == arr[mid])
			{
				return mid;
			}
			/*
			 * this part of code below 2 lines is required along with rest of the logic if its not circular array but almost sorted by modifying binary
			 * search little bit. O(logn) time. Mainly for any nearly sorted array you can apply this logic
			 * for example :- int[] arr = new int[]{10, 3, 40, 20, 50, 80, 70};
			 * */
			//if (mid > low && arr[mid-1] == num) return (mid - 1);
	        //if (mid < high && arr[mid+1] == num) return (mid + 1);
	        
	        
	        
			else if(arr[low] < arr[mid] ) // case when numbers are increasing till mid and then decreasing
			{
				return (num >= arr[low] && num < arr[mid] ? searchInCircularArray(arr ,  num, low, mid-1) 
						:searchInCircularArray(arr ,  num, mid+1, high));
			}
			//arr[low] > arr[mid]  // case when numbers are decreasing till mid and then increasing 
			else 
			{
				return (num > arr[mid] && num <= arr[high] ? searchInCircularArray(arr ,  num, mid+1, high) 
						:searchInCircularArray(arr ,  num, low, mid-1));
			}
		}
		return -1;	
		
	}
}



