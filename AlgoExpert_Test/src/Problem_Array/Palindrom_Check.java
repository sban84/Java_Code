package Problem_Array;

public class Palindrom_Check {
	
	public static void main(String[] args) {
		System.out.println(isPalindrom("abcdcba"));
	}
	
	public static boolean isPalindrom(String str) {
		if(str.equals(reverseInPlace(str))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//"abc" 
	public static String reverseInPlace(String str) {
		if(str.length() < 2 ) return str;
		else {
			return reverseInPlace(str.substring(1)) + str.charAt(0);
		}
	}

}
