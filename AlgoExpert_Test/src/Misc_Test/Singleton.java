package Misc_Test;

import java.io.Serializable;

public enum Singleton implements Serializable{
    INSTANCE;
 
    public void show(){
        System.out.println("Singleton using Enum in Java");
    }
    private int user_id ;
    private String user_name ;
    
    public int getUserId() {
    		return user_id;
    }
    
    public String getUserName() {
		return user_name;
    }
    
    public static Singleton getInstance() {
    		return INSTANCE;
    }
}

//Read more: https://javarevisited.blogspot.com/2012/12/how-to-create-thread-safe-singleton-in-java-example.html#ixzz6KFSwxzE7


