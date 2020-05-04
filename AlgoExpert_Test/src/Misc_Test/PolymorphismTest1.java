package Misc_Test;
public class PolymorphismTest1 {
	
	public static void main(String args[])
	{
		Animal1 an = new Animal1();
		//an.bark();//will call animal.bark()
		System.out.println("a=" + an.a);
		System.out.println("b=" + an.b);
				
		Animal1 an1 = new Cat1();
		//InstanceOf Test
		System.out.println("an1 test " + (an1 instanceof Cat1)); // true - since an1 ref points to object instance of Cat1

		an1.bark();//will call cat1.bark()  .. through polymorphism we can call only overridden methods, mean if there is no bark() in Cat, then this wil call 
		//animal.bark(). but if there is no bark() in Animal but Cat1 has then its not polymorphism and then this will give compilation error. 
		System.out.println("a=" + an1.a); // Variables can not be overridden 
		System.out.println("b=" + an1.b);
		//an1.eat(); because its not there in Animal1 class . only overriden method can be accessed through polymorphism.
		
		//this below code is same as creating cat ref and pointing to cat object
		Cat1 c1 = new Cat1();
		c1=(Cat1) an1;
		c1.bark();
		c1.eat();
		System.out.println("a=" + c1.a); // this is hidding not overriding as variables can not be overrriden
		System.out.println("b=" + c1.b);
	}
}

class Animal1
{
	int a=10;
	static int b=20;
	
	public void bark()
	{
		System.out.println("Inside Animal1 bark() ");
	}
}

class Cat1 extends Animal1
{
	int a=11;
	static int b=21;
	
	public void bark()
	{
		System.out.println("Inside Cat1 bark() ");
	}
	public void eat()
	{
		System.out.println("Inside Cat1 eat() ");
	}
}