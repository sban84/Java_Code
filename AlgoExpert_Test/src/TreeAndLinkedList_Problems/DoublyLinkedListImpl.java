package TreeAndLinkedList_Problems;

public class DoublyLinkedListImpl {
	
	
	int value ;
	DoublyLinkedListImpl prev;
	DoublyLinkedListImpl next ;
	
	public DoublyLinkedListImpl(int value ) {
		this.value = value;
		this.next = null;
		this.prev = null;
	}
	
	@Override
	public String toString() {
		return "DoublyLinkedListImpl [value=" + value + "]";
	}

	public static DoublyLinkedListImpl head;
    public static DoublyLinkedListImpl tail;
    
    
	public static void main(String[] args) {
		
		DoublyLinkedListImpl n1 = new DoublyLinkedListImpl(1);
		//head = instance;
		head = n1;
		tail = head;
		head.prev = null;
		tail.next = null;
		
		System.out.println("head added >> " + head.toString());
		DoublyLinkedListImpl n2 = head.setHead(10);
		DoublyLinkedListImpl n3 = head.setHead(11);
		head.traversal(head);
		
		DoublyLinkedListImpl newTailAdded = head.setTail(new DoublyLinkedListImpl(100));
		System.out.println("\n new tail " + newTailAdded);
		
		head.insertBefore(n1, new DoublyLinkedListImpl(5));
	}
	
	public DoublyLinkedListImpl setHead(int value) {
		DoublyLinkedListImpl newNode = new DoublyLinkedListImpl(value);
		newNode.next = head;
		newNode.prev = head.prev;
		head.prev = newNode;
		head = newNode;
		return head;
	}
	
	
	public void traversal(DoublyLinkedListImpl head) {
		DoublyLinkedListImpl node = head;
		System.out.println("Traversing in Forward direction >> ");
		while(node != null) {
			System.out.print(node.value + "->");
			node = node.next;
		}
	}
	
	
	public DoublyLinkedListImpl setTail(DoublyLinkedListImpl node) {
		DoublyLinkedListImpl curr = head;
		while(curr != tail) {
			curr = curr.next;
		}
		node.prev = curr;
		node.next = curr.next;
		
		curr.next = node;
		tail = node ;
		return tail;
	}

	// 11 ->10 ->1 -- null
	public void insertBefore(DoublyLinkedListImpl node, DoublyLinkedListImpl nodeToInsert) {
		DoublyLinkedListImpl curr = head;
		
		while(curr.next != node) {
			curr = curr.next;
		}
		nodeToInsert.next = curr.next;
		curr.next.prev = nodeToInsert;
		
		curr.next = nodeToInsert;
		nodeToInsert.prev= curr;
		
		System.out.println("nodeToInsert addedd " + nodeToInsert.toString() + " after " + nodeToInsert.prev.toString() + " and nodeToInsert.next " + nodeToInsert.next.toString());
		
	}
	
	/*	public void insertAfter(Node node , Node nodeToInsert) {
		Node curr = head;
		while(curr.value != node.value) {
			curr = curr.next;
		}
		Node currNext = curr.next;
		
		curr.next = nodeToInsert;
		nodeToInsert.prev = curr;
		
		nodeToInsert.next = currNext;
		currNext.prev = nodeToInsert;
		
	}
	
	public void insertAtPosition(int position, Node nodeToInsert) {
		int pointer =1;
		Node curr = head;
		while(pointer < position) {
			pointer++;
			curr = curr.next;
		}
		Node next = curr.next;
		curr.next= nodeToInsert;
		nodeToInsert.prev = curr;
		
		nodeToInsert.next = next;
		next.prev = nodeToInsert;
	}
	
	public void removeNodesWithValue(int value) {
		Node curr = head;
		while(curr.next != null) {
			if(curr.next.value == value) {
				Node nodeAfterDeletedNode = curr.next.next ;
				curr.next =  nodeAfterDeletedNode;
				nodeAfterDeletedNode.prev = curr;
			}
			else {
				curr = curr.next;
			}
		}
	}
	
	public void remove(Node node) {
		Node curr = head;
		while(curr.next != node) {
			curr = curr.next;
		}
		Node nodeAfterDeletedNode = curr.next.next ;
		curr.next =  nodeAfterDeletedNode;
		nodeAfterDeletedNode.prev = curr;
	}
	
	public boolean containsNodeWithValue(int value) {
		Node curr = head;
		while(curr.next != null) {
			if(curr.value == value) {
				return true;
			}
		}
		return false;
	}*/
	
	
	
	
	
}


