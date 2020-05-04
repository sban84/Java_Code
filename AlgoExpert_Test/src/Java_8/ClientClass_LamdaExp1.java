package Java_8;

public class ClientClass_LamdaExp1 {
	
	public static void main(String[] args) {
		
		MyFuncInterface func_instance = (String a ,String b) -> { String res = a.concat(b) ; System.out.println(res);};
		func_instance.addString("a", "b");
		
		MyFuncInterface_2 myInterface_2 = (a,b) -> { 
			String res = a + b ; 
			return res;
			};
			
		String returned_result  = myInterface_2.addAndReturn("a", "b");
		System.out.println("returned_result  " + returned_result);
	}

}
