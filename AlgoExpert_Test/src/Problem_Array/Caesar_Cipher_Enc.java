package Problem_Array;

/*
 * 
 */
public class Caesar_Cipher_Enc {
	
	public static void main(String[] args) {
		String result = encrypt("xyz" , 54);
		System.out.println("result = " + result);
		
	}
	
	public static String encrypt(String str , int key) {
		StringBuffer sb = new StringBuffer();
		if( key > 26) { 
			key = key%26;
		}		
		for(int i =0; i< str.length(); i++) {
			int ASCII_value =  str.charAt(i) + key ;
			if(ASCII_value > 122) {
				ASCII_value = 96 + (ASCII_value % 122) ;
			}
			sb.append((char)ASCII_value);
			System.out.println("ASCII_value" + (char)ASCII_value);
		}
		
		return sb.toString();
		
	}

}


// also refer https://www.techiedelight.com/right-rotate-an-array-k-times/