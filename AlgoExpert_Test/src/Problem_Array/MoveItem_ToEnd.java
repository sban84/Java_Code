package Problem_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveItem_ToEnd {
	
	public static void main(String[] args) {
		//2,2,2,3,4,2
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(2,1,2,3,4,2));
		List result = MoveToEnd(list,2);
		
		for(int i=0;i<result.size(); i++) {
			System.out.println("result " + result.get(i));
		}
		
		
	}
	
	public static List<Integer> MoveToEnd(List<Integer> array , int toMove) {
		for(int i =0, j= array.size() -1 ; i < j;) {
			int curr_item = array.get(i);
			int last_item = array.get(j);
			boolean moveICounter= true;
			
			System.out.println("i>> " + i);
			//System.out.println("curr_item>>---->  " + curr_item);
			if(curr_item == toMove) {
				
				if(last_item == toMove) {
					//System.out.println("last_item>> " + last_item);
					moveICounter = false;
					j--;
				}
				else {
					
					int temp = last_item;
					array.set(j, curr_item);
					array.set(i,temp);
					i++;
					j--;
				}
			}
			if(moveICounter)
			i++;
			
		}
		
		return array ;
	}

}
