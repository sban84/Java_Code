package Crack_Code_Array;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// very ggod algo to sort a finite number of chars .
// geeksforgeeks.org/sort-string-characters/
public class Array_problem_4_StringFixedLength {
	
	
	public static void main(String[] args) {
		//sortString("abad");
		
		sortStringUsingMap("abad");
	}

	static void sortString(String str) {
		
		int MAX_CHAR = 26;
		  
        // Hash array to keep count of characters. 
        int letters[] = new int[MAX_CHAR]; 
  
        // Traverse string and increment 
        // count of characters 
        for (char x : str.toCharArray()) { 
  
            // 'a'-'a' will be 0, 'b'-'a' will be 1, 
            // so for location of character in count 
            // array we will do str[i]-'a'. 
            letters[x - 'a'] = letters[x - 'a'] + 1; 
        } 
  
        for(int i=0 ; i < letters.length; i++) {
        		System.out.print( letters[i] + ","); 
        }
        
        
        // Traverse the hash array and print 
        // characters 
        for (int i = 0; i < MAX_CHAR; i++) { 
            for (int j = 0; j < letters[i] ; j++) { 
                System.out.print((char) (i + 'a')); 
            } 
        } 
    } 
	
	
	public static void sortStringUsingMap(String str) {
		
		Map<Character, Integer> char_map = new TreeMap<Character,Integer>();
		for(int i=0;i < str.length() ; i++) {
			char ch = str.charAt(i);
			if(!char_map.containsKey(ch)) {
				char_map.put(ch, 1);
			}
			else {
				int inr_count = char_map.get(ch) +1 ;
				char_map.put(ch, inr_count);
			}
		}
		System.out.print("map >>" +  char_map);
		// iterate through map and print chars by its values.
		Set<Map.Entry<Character,Integer>> set = char_map.entrySet();
		Iterator<Map.Entry<Character,Integer>> itr = set.iterator();
		while(itr.hasNext()) {
			Map.Entry<Character, Integer> me = itr.next();
			for(int j=0 ; j < me.getValue() ; j++) {
			System.out.print(me.getKey() + ",");
			}
		}
		
	}
}
