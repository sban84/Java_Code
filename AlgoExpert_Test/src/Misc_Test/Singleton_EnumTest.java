package Misc_Test;

public class Singleton_EnumTest {
	
	public static void main(String[] args) {
		Singleton s = Singleton.INSTANCE;
		System.out.println("instance s " + s.hashCode());
		System.out.println("user_id" + s.getUserId());
		Singleton s1 = Singleton.getInstance();
		System.out.println("instance s1 " + s1.hashCode());
		System.out.println("user_id" + s1.getUserId());
	}

}
