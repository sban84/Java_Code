package Java_8;

import java.util.Iterator;
import java.util.ListIterator;

// https://stackoverflow.com/questions/43661433/java-default-interface-methods-concrete-use-cases

// https://beginnersbook.com/2017/10/java-8-interface-changes-default-method-and-static-method/

/*
 * 1- Interface Evolution

The primary use case of default methods is interface evolution. Mainly, this is the ability to add methods to interfaces 
without breaking backward compatibility. As noted in the question, this was most prominently 
employed to add methods allowing conversion of Collections to Streams and to add lambda-based APIs to Collections.

2- Convenience Methods

Sometimes a method is provided for the convenience of callers, and there is an obvious and optimal implementation. 
This implementation can be provided by a default method. It's legal for an implementation to override the default, but there's generally no reason, so implementations will usually inherit it. Examples: Comparator.reversed, Spliterator.getExactSizeIfKnown, Spliterator.hasCharacteristics. Note that Spliterator was introduced in Java 8, including the default methods, so this clearly wasn't a case of interface evolution.

3- Simple Implementation, Intended to be Overridden

A default method can provide a simple, general implementation that works for all implementations, but that is probably suboptimal. This assists implementations during initial bring-up, because they can inherit the default and be assured of correct operation. However, in the long term, implementations will probably want to override the default and provide an improved, customized implementation.
Example: List.sort. The default implementation copies the list elements to a temporary array, sorts the array, and copies the elements back to the list. This is a correct implementation, and sometimes it can't be improved upon (e.g. for LinkedList). However, ArrayList overrides sort and sorts its internal array in-place. This avoids the copying overhead.
Now, obviously sort was retrofitted onto List and ArrayList in Java 8, so the evolution didn't happen this way. But you could easily imagine bringing up a new List implementation. You'd probably initially inherit the sort default implementation while you're getting the basics implemented properly. Later on, you might consider implementing a customized sort algorithm that's tuned to your new implementation's internal data organization.
 */

// Ex:- JDK interfaces are Comparator.java it has many default methods. List has removeAll, sort and again ArrayList class override the default method of sort , Map.Entry has CompareKeys as static methods 
//
interface Drawable {
	
	// interfaces are public & abstract by default
	void draw();
	
	public void abstractMethod();

	default  void msg() {
		System.out.println("default method");
	}

	// practical use case is to provide helper classes / utility classes. only diff. is this we can't override. and we call this by InterfaceName itself.
	public static void a() {
		System.out.println("a method");
	}
}

class Rectangle implements Drawable {
	
	@Override
	public void draw() {
		System.out.println("drawing rectangle");
	}
	
	@Override
	public void abstractMethod() {
		System.out.println("in class override abstractMethod");
	}

	// OPTIONAL 
	/*@Override
	public void msg() {
		System.out.println("custom method");
	}*/
	
	// this is not override. 
	/*public static void a() {
		System.out.println("a method in class as override");
	}*/
}

class TestInterfaceDefault {
	public static void main(String args[]) {
		Drawable d = new Rectangle();
		d.draw();
		d.msg();
		//d.a();
		Drawable.a();
		
		//Rectangle.a();
		
		/*Rectangle ins = new Rectangle();
		ins.a();*/
		
		
		
	}
}
