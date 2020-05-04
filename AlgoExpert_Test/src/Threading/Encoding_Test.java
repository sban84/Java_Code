package Threading;

public class Encoding_Test {

	public static void main(String[] args) {
		function("AAAABBCAA");
	}
	
	public static String function(String str) {
		StringBuffer sb = new StringBuffer();
		int temp = 1;
		for(int i=0 ; i<= str.length() -2 ; i++) {
			//System.out.println(i);
			char curr = str.charAt(i);
			char next = str.charAt(i + 1);
			//System.out.println(curr);
			//System.out.println(next);
			
			if(curr == next) {
				
				temp = temp +1 ;
			}
			else {
				sb.append(temp);
				sb.append(curr);
				temp = 1;
				//System.out.println(str.length());
				
			}
			//specially to handle last chars 
			if(str.length() == i+2) {
				sb.append(temp);
				sb.append(next);
			}
			
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	
}
