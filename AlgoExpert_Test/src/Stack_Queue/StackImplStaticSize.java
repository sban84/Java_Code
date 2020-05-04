package Stack_Queue;

import java.util.Arrays;
import java.util.Stack;
import java.util.Vector;


/*
 * Stack i=n java uses vector internally , but I am using Array for simplicity.
 * Very good to understand that Stack in java is dynamic . 
 * But we are implementing custom stack . this is static stack.
 * 
 */
public class StackImplStaticSize {
	
	public static void main(String[] args) {
		//stack_api_test();
		
		StackImplStaticSize stack = new StackImplStaticSize(3);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(11);
		
		int item = (int)stack.pop();
		System.out.println("item popped " + item);
		stack.push(12);
		System.out.println("item popped " + (int)stack.pop());
		System.out.println("item popped " + (int)stack.pop());
		
		/*Vector v = new Vector<Object>();
		v.add(1);
		v.get(0);
		Object[] temp = Arrays.copyOf(v.toArray(), v.size());*/
	}
	
	int capacity = 0;
	int top = -1; // will decide that how many items are present in the Stack. no need to maintain another counter here.
	Object[] array;
	
	public StackImplStaticSize(int size) {
		this.array = new Object[size];
		capacity = size;
		
	}
	public StackImplStaticSize() {
		this.array = new Object[10]; // by default
		 capacity = 10;
	}
	
	// methods 
	public boolean isEmpty() {
		return top <0 ? true : false;
	}
	
	public boolean isFull() {
		if(top == capacity -1 ) {
			return true;
		} 
		else
		return false;
	}
	
	public Object push(Object item) {
		if(isFull()) {
			System.out.println("Stack is Full");
			return -1;
		}
		else {
			array[++top] = item;
			System.out.println("Item pushed successfully " + item);
			return item;
		}
	}
	
	public Object pop() {
		if(isEmpty()) {
			System.out.println("Stack is Empty");
			return -1;
		}
		else {
			Object item = array[top];
			top--;
			return item ;
		}
	}
	
	
	
	
	
	public static void stack_api_test() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(1);
		stack.push(1);
		stack.push(1);
		
		System.out.println("stack " + stack.size());
	}
	
	
	
	

}
