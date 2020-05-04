package Stack_Queue;

import java.util.Arrays;

/*
 * Very good stack impl using dynamic array concept in Java .
 * 
 */
public class StackImplDynamicSize {
	
	
	public static void main(String[] args) {
		StackImplDynamicSize stack = new StackImplDynamicSize(3);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(11);
		
		int item = (int)stack.pop();
		System.out.println("item popped " + item);
		stack.push(12);
		System.out.println("item popped " + (int)stack.pop());
		System.out.println("item popped " + (int)stack.pop());
	}
	
	int capacity =0;
	int top = -1;
	Object[] array;
	
	public StackImplDynamicSize(int size) {
		capacity = size;
		array = new Object[size];
	}
	public StackImplDynamicSize() {
		capacity = 10;
		array = new Object[10];
	}
	
	public boolean isEmpty() {
		return top < 0 ? true : false;
	}
	
	public boolean isFull() {
		if(top == capacity -1) {
			return true;
		}
		else {
			return false;
		}
	}
	public Object push(Object item) {
		if(isFull()) {
			System.out.println("Stack is Full");
			resize();
			array[++top] = item;
			System.out.println("Item pushed successfully after resize " + item);
			return item;
		}
		else {
			array[++top] = item;
			System.out.println("Item pushed successfully " + item);
			return item;
		}
	}
	
	private Object[] resize() {
		int new_capacity = capacity * 2;
		Object[] temp ;
		temp = Arrays.copyOf(array, new_capacity);
		/*System.out.println("resize >>");
		
		for(int i=0 ; i< temp.length ; i++) {
			System.out.print(temp[i] +",");
		}*/
		
		capacity = new_capacity;
		array = temp;
		return array;
		
	}
	public Object pop() {
		if(isEmpty()) {
			System.out.println("Stack is Empty");
			return -1;
		}
		else {
			Object item = array[top];
			top--;
			return item;
		}
	}
	
	public Object peek() {
		return array[top] ;
	}

}
