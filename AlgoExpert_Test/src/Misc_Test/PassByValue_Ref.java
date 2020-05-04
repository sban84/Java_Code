package Misc_Test;


public class PassByValue_Ref {

	public static void main(String[] args)
	 {
	 // Part I � primitive data types
	 int i = 25;
	 System.out.println(i); // print it (1)
	 iMethod(i);
	 System.out.println(i); // print it (3)
	 System.out.println("----------------------------");

	 // Part II � objects and object references
	 StringBuffer sb = new StringBuffer("Hello, world");
	 String sb1 = new String("Hello, world");
	 System.out.println(sb1); // print it (4)
	 sbMethod(sb1);
	 
	 System.out.println(sb1); // print it (6)
	 System.out.println("----------------------------");

	 // Part III � strings
	 String s = "Java is fun!";
	 System.out.println(s); // print it (7)
	 sMethod(s);
	 System.out.println(s); // print it (9)
	 
	// for reference Chedck 
	 
		 testPassByRef instance = new testPassByRef();
		 System.out.println("testPassByRef before change  >>" + instance);
		 int x =100;
		 Integer y = new Integer(100);
		 String z = "abc";
		 
		 testPassByRefTest(instance , x,y,z);
		 System.out.println("testPassByRef After change  >>" + instance);
		 
		 System.out.println("no instance variables " + "x "  + x + "y "  + y + "z "  + z);
	 }

	 public static void iMethod(int iTest)
	 {
	 iTest = 9; // change it
	 System.out.println(iTest); // print it (2)
	 }

	 public static void sbMethod(String sbTest)
	 {
	 sbTest = sbTest.substring(5, 7); // change it
	 System.out.println(sbTest); // print it (5)
	 }

	 public static void sMethod(String sTest)
	 {
	 sTest = sTest.substring(8, 11); // change it
	 System.out.println(sTest); // print it (8)
	 }
	 
	 
	 // for reference Chedck 
	 
	 public static void testPassByRefTest( testPassByRef instance , int x , Integer y , String z) {
		 
		 instance.a =20;
		 instance.b = 20;
		 instance.c = "new hellow";
		 instance.d = "new Morning";
		 
		 System.out.println("Inside testPassByRef After change  >>" + instance);
		 
		 x= 1000;
		 y = 1000;
		 z= "bbb";
	 }
	 
	 
}

class testPassByRef{
	int a =10;
	Integer b = new Integer(12);
	String c = "hello";
	String d = new String("Morning");
	
	

	@Override
	public String toString(){
		return "testPassByRef >> " + a + ", " + b + ", " + c + ", " + d;
	}
	
}
