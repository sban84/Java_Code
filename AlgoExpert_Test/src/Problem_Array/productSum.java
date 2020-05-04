package Problem_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class productSum {
	
	public static void main(String[] args) {
		
		/*List<Object> list = new ArrayList<Object>();
		list.add(5);
		list.add(2);
		
		List<Integer> list1 = new ArrayList<Integer>();
		
		list1.add(7);
		list1.add(-1);
		
		list.add(list1);*/
		
		
		List<Object> list = new ArrayList<Object>(Arrays.asList(5, 2, new ArrayList<Object>(Arrays.asList(7,-1)), 3, new ArrayList<Object>(Arrays.asList(6, new ArrayList<Object>(Arrays.asList(-13,8)),4  ))   ));
		
		int result = productSumFun( list);
		
		System.out.println("productSumFun " +  result );
	}
	
	public static int productSumFun(List<Object> list) {
		return productSumRec(list,1);
	}
	
	private static int productSumRec(List<Object> list, int multiplier) {
		int sum =0;
		for (Object object : list) {
			if(object instanceof ArrayList) {
				sum += productSumRec((ArrayList)object  , multiplier + 1 );
			}
			else {
				sum += (int)object;
				//System.out.println("sum " + sum);
			}
			
		} 
		
		return sum * multiplier;
		
	}

}
