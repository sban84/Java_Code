package Java_8;

@FunctionalInterface
interface MyFunctionalInterface {

    public int addMethod(int a, int b);
}
public class BeginnersBookClass {

   public static void main(String args[]) {
        // lambda expression
    	MyFunctionalInterface funcInterface_instance = (a, b) -> a + b;
        System.out.println("Result: "+funcInterface_instance.addMethod(12, 100));
    }
}
