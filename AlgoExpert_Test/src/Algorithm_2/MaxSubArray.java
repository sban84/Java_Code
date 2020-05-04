package Algorithm_2;

public class MaxSubArray {
	
	public static void main(String args[])
	{
		int[] arr = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
		//int[] arr = new int[]{-2, 3, 7, -2, -5};
		//int[] arr = new int[]{-3,-2,-5};
		int result = LargestSum(arr,arr.length,0,2);
		System.out.println("max sum is " + result);
	}
	
	private static int LargestSum(int[] index, int size, int startIndex, int endIndex){
		int i;
		int max_so_far, max_ending_here;
		max_so_far= Integer.MIN_VALUE;
		max_ending_here = 0;
		for(i=0; i< size;i++){
			max_ending_here=max_ending_here + index[i];
			if(index[i] > max_ending_here){
				max_ending_here = index[i]; 
				startIndex = i;
			}
			if(max_ending_here > max_so_far){
				max_so_far = max_ending_here;
				endIndex = i;
			}
			//System.out.println( max_so_far +" " + max_ending_here);
		}
		System.out.println("Max sub array index range  " + startIndex +" and " + endIndex);
		System.out.print("Max sub array ");
		for(int k= startIndex; k<= endIndex ; k++)
		{
			System.out.print(index[k] + " , ");
		}
		System.out.println("\n");
		return max_so_far;
	}

}
