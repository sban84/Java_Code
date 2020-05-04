package TreeAndLinkedList_Problems;

import java.util.ArrayList;
import java.util.List;

public class SinglyLinkedList {
	
	
	
	
	int value;
	SinglyLinkedList next;
	
	static SinglyLinkedList head = null;
	static SinglyLinkedList tail = null;
	
	public SinglyLinkedList(int value, SinglyLinkedList next) {
		
		this.value=value;
		this.next = next;
	}
	// mostly we will use this
	public SinglyLinkedList(int value) {
		
		this.value=value;
		this.next = null;
		
	}
	
	public String toString() {
		return "LInked List " + value;
	}
	public static void main(String[] args) {
		
		
		
		SinglyLinkedList n1 = new SinglyLinkedList(1);
		head = n1;
		tail = n1;
		head.next = null;
		System.out.println("added head first node " + head.toString());
		
		SinglyLinkedList n2 = head.setHead(10);
		SinglyLinkedList n3 = head.setHead(12);
		
		System.out.println("after calling setHead " + n3.toString());
		
		head.traverse();
		head.reverseLinkedList(head);
		
	}
	
	//Adding new node at head.
	public SinglyLinkedList setHead(int value) {
		SinglyLinkedList node = new SinglyLinkedList(value);
		node.next = head;
		head = node;
		return head;
	}
	
	//Traversal , from head to till
	public void traverse() {
		System.out.println("Traversing in Forward direction >> ");
		SinglyLinkedList curr = head;
		while(curr != null) {
			System.out.print(" ->" + curr.value);
			curr = curr.next;
		}
	}
	
	public void reverseLinkedList(SinglyLinkedList head) {
		System.out.println("\n Reverse The LLinked list >> ");
		SinglyLinkedList curr = head;
		SinglyLinkedList head_copy = head;
		SinglyLinkedList prev = null;
		
		while(curr != null) {
			SinglyLinkedList next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			
		}
		head_copy = prev;
		
		SinglyLinkedList curr1 = head_copy;
		while(curr1 != null) {
			System.out.print(" ->" + curr1.value);
			curr1 = curr1.next;
		}
	}

}
