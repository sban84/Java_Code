package Stack_Queue;

import java.util.ArrayList;
import java.util.List;

public class QueueImplStaticSize {
	
	int front =-1;
	List<Object> list = new ArrayList<Object>();
	int capacity;
	int size =0;
	boolean isDynamic = false;
	
	public static void main(String[] args) {
		
		/*Queue q1 = new LinkedList();
		q1.add(1);
		q1.add(2);
		q1.poll();
		System.out.println("Queue >> "+ q1);*/
		
		// this is static test 
		/*QueueImplStaticSize q_static = new QueueImplStaticSize(3);
		q_static.add(1);
		q_static.add(2);
		q_static.add(3);
		//q_static.add(3); // is full.
		
		System.out.println("q_static " + q_static.poll());
		//System.out.println("q_static " + q_static.poll());
		q_static.add(3);
		System.out.println("q_static " + q_static.poll());*/
		
		
		QueueImplStaticSize q_static = new QueueImplStaticSize();
		q_static.add(1);
		q_static.add(2);
		q_static.add(3);
		//q_static.add(3); // will never be full.
		
		System.out.println("q_static " + q_static.poll());
		//System.out.println("q_static " + q_static.poll());
		q_static.add(3);
		System.out.println("q_static " + q_static.poll());
		
		
		
		
		
		
	}
	
	
	public boolean isFull() {
		return list.size()==capacity ? true : false; 
	}
	
	public boolean isEmpty() {
		if(list.size() ==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Object add(Object item) {
		if(!isDynamic) {
			if(isFull()) {
				System.out.println("Queue is Full.");
				return -1;
			}
			else {
				list.add(item);
				System.out.println("Item added successfully in static Queue " +item);
				return item;
			}
			
		}
		else {
			list.add(item);
			System.out.println("Item added successfully in dunamic Queue " +item);
			return item;
		}
		
	}
	
	
	public Object poll() {
		if(isEmpty()) {
			System.out.println("Queue is Empty.");
			return -1;
		}
		else {
			Object item = list.remove(0); // remove and return the item.
			return item;
			
		}
	}
	
	// lets consider , if we don't pass any size its dynanic in size ( then we dont have to another  class like stack we did )
	public QueueImplStaticSize() {
		list = new ArrayList<Object>();
		//capacity = 10;
		isDynamic = true;
	}
	
	public QueueImplStaticSize(int size) {
		list = new ArrayList<Object>(size);
		capacity = size;
	}

}
