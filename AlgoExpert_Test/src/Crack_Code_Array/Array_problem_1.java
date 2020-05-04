package Crack_Code_Array;


import java.math.BigInteger;
// also refer rotate a array good :- https://www.techiedelight.com/right-rotate-an-array-k-times/ 
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Array_problem_1 {
	
	public static void main(String[] args) {
		//checkUniqueInPLace("abcadba");
		//getUserInput();
		
		
		
		
		
	}
	
	public static void checkUniqueInPLace(String str) {
		char[] char_array = str.toCharArray();
		Arrays.sort(char_array);
		boolean duplicateFound = false;
		StringBuffer sb = new StringBuffer();
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		
		for(int i=0; i< char_array.length-1 ; i++) { // if we wanted to break use && !duplicateFound
			char first = char_array[i];
			char sec = char_array[i+1];
			if(first == sec) {
				duplicateFound= true;
				// break; // if we need to stop after finding the first duplicate. to know all then proceed below...
				sb.append(first);
				if(map.containsKey(first)) {
					map.put(first,map.get(first) + 1);
				}
				else {
					map.put(first, 1);
				}
			}
		}
		
		if(duplicateFound) {
			System.out.println(sb);
			System.out.println(map);
			//iterateAMap(map);
		}
		
	}
	
	public static void getUserInput() {
		System.out.println("Enter a number of i/p ");
		Scanner scanner =  new Scanner(System.in);
		int inp = scanner.nextInt();
		scanner.nextLine();// this is for the bug in Scanner extra 
		System.out.println("inp " + inp);
		
		do{
			System.out.println("Enter a string ");
			String str = scanner.nextLine();
			replaceSomeCharInSring(str);
			inp--;
		}while(inp >0);
		//scanner.close();
		
		
	}
	
	public static void replaceSomeCharInSring(String str) {
		String[] str_array = str.split(" ");
		StringBuffer sb = new StringBuffer();
		for(int i=0; i< str_array.length -1; i++) {
			sb.append(str_array[i] + "%20");
		}
		sb.append(str_array[str_array.length-1] );
		System.out.println("sb " + sb.toString());
		
	}
	
	
	
	
	
	
	
	// just to test how to iterate map if required 
	public static void iterateAMap(Map<Character,Integer> map) {
		Set<Entry<Character,Integer>> set = map.entrySet();
		Iterator itr = set.iterator();
		
		while(itr.hasNext()) {
			Map.Entry<Character, Integer> me = (Map.Entry<Character, Integer>)itr.next();
			System.out.println("key  " + me.getKey());
			System.out.println("value  " + me.getValue());
		}
		
		
	}

}
