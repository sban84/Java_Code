package Crack_Code_Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ReverseAString {
	
	public static void main(String[] args) {
		//char[] input = new char[] {'h','e','l','l','o'};
		
		char[] input = new char[]{'h','e','l','l'};
		String result = reverseUsingRec(input.toString());
		//System.out.println("result " + result.toCharArray());
		System.out.println("--------- Reversing a char [] -----------" + result);
		
		reverseUsingRec(input);
		
		/*List<Integer> values 
        = Arrays.asList(212, 324, 
                        435, 566, 
                        133, 100, 
                        121); 

    // reverseOrder is a static method 
    values.sort(Comparator.reverseOrder()); 
    System.out.println(values);*/
		
	}
	
	public static String reverseUsingRec(String str) {
		int len = str.length() ;
		if(len < 2) return str;
		else {
			return reverseUsingRec(str.substring(1, len)) + str.charAt(0);
			
		}
	}

	public static void reverseUsingRec(char[] ch) {
	
		int len = ch.length;
		for(int i =0, j = len-1;  i< j ; i++, j--) {
			char temp = ch[i];
			ch[i] = ch[j];
			ch[j] = temp;
		}
		
		for (char c : ch) {
			System.out.print(c + ",");
		}
	}
	
	
}
