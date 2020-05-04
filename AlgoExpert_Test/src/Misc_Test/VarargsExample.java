package Misc_Test;

public class VarargsExample {

    public static void main(String[] args) {
        System.out.println(sum(1));
        System.out.println(sum(1,2,3)); //compiler error, ambiguous method

    }

    public static int sum(int i, int...js ){
        System.out.println("sum1 called");
        int sum = i;
        for(int x : js){
            sum+=x;
        }
        return sum;
    }
   /* public static int sum( i, int k, Object...js ){
        System.out.println("sum2 called");
        int sum = i+k;
        for(Object x : js){
            sum+=1;
        }
        return sum;
    }*/
    
}