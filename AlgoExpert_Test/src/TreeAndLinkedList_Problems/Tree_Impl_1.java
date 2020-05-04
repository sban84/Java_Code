package TreeAndLinkedList_Problems;

// BST implementation and its useful API
public class Tree_Impl_1 {
	
	
	static Node root = null;
	public static void main(String[] args) {
		
		Tree_Impl_1 tree = new Tree_Impl_1();
		
		tree.insert(8);
		tree.insert(10);
		tree.insert(20);
		tree.insert(1);
		tree.insert(50);
		
		tree.inOrder() ;
		
		System.out.println(" Size = " + tree.getSize(root));
	}
	
	public void insert(int value) {
		root = insert(root, value);
		System.out.println("Inserted .." + root.value);
	}

	private Node insert(Node root , int value) {
		if(root == null) {
			Node node = new Node(value);
			return node ;
		}
		else if(value < root.value)
			root.left = insert(root.left,value);
		else 
			root.right = insert(root.right , value);
		
		return root;
	}
	
	public void inOrder() {
		inOrder(root);
	}
	
	private void inOrder(Node root) {
		if(root == null) return;
		else {
			inOrder(root.left);
			System.out.print(" " + root.value + " ");
			inOrder(root.right);
		}
	}
	
	public int getSize(Node root) {
		if(root == null) return 0;
		
		else {
			int l = getSize(root.left);
			int r = getSize(root.right);
			return Math.max(l, r) + 1;
		}
	}
	

}




class Node {
	int value;
	Node left;
	Node right;
	
	public Node(int value) {
		this.value = value;
		this.left = null;
		this.right = right;
	}
}
