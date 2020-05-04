package onlineTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//http://algorithms.tutorialhorizon.com/breadth-first-searchtraversal-in-a-binary-tree/
// Very good example of Tree. 

public class BinaryTreeTest {
	static MyNode newRoot;

	/* Not sure what is doing 
	 * public int SumTree(MyNode root){
		if(root!=null){
			int left = SumTree(root.left);//take the left tree sum
			int right = SumTree(root.right);//take the right tree sum
			int retData = root.data+left+right; // return data left+right+root
			root.data = left+right; //update the root with left + right
			newRoot = root; //update the new root
			return retData; //return 
		}
		return 0;
	}*/
	public void display(MyNode root){
		if(root!=null){
			display(root.left);			
			System.out.print(root.data + "  " );
			display(root.right);
		}
	}
	
	/*
	 *            5
	 *        /       \
	 *       -1        3
	 *     /    \     / \
	 *    -2     4   -6  10
	 */
	public static void main(String args[]){
		MyNode root = new MyNode(5);
		root.left = new MyNode(-1);
		root.right = new MyNode(3);
		root.left.left = new MyNode(-2);
		root.left.right = new MyNode(4);
		root.right.left = new MyNode(-6);
		root.right.right = new MyNode(10	);
		BinaryTreeTest t = new BinaryTreeTest();
		System.out.print("Original Tree: ");
		//t.display(root);
		levelOrderQueue(root);
		addANumEachNode(root,3);
		//Print the new tree
		//t.display(newRoot);
		//levelOrderQueue(root);
	}
	
	public static void addANumEachNode(MyNode root , int num) {
	
		System.out.println(" \n Adding node logic ---> \n" );
		List<Integer> list = new ArrayList<Integer>();
		Queue<MyNode> q = new LinkedList<MyNode>();
		if(root == null) return;
		q.add(root);
		while(! q.isEmpty()) {
			MyNode n = (MyNode)q.poll();
			
			System.out.print(" " + (n.data + num));
			list.add((n.data + num));
			if(n.left != null)
				q.add(n.left);
			if(n.right != null)
				q.add(n.right);
		}
		
		MyNode new_tree = listToTree(list);
		levelOrderQueue(new_tree);
	}
	
	// This is very good logic any list / array can be converted to Tree ( the order of items will be added as tree level wise)
	public static MyNode listToTree(List<Integer> input){
	    MyNode root = createTreeNode(input,0);
	    return root;
	}

	private static MyNode createTreeNode(List<Integer> input, int k){
	    if(k < input.size()){
		    	int value = input.get(k);
		    	MyNode t = new MyNode(value);
	        t.left = createTreeNode(input, k*2+1);
	        t.right = createTreeNode(input, k*2+2);
	        return t;
	    }
	    return null;
	}
		
		// finally test root_after_add
		//levelOrderQueue(root_after_add);
				
	
	
	// This is BFS or Level order traversal
	public static void levelOrderQueue(MyNode root) {
		System.out.println(" \n BFS TRavel ---> \n" );
		Queue<MyNode> q = new LinkedList<MyNode>();
		if (root == null)
			return;
		q.add(root);
		while (!q.isEmpty()) {
			MyNode n = (MyNode) q.remove();
			System.out.print(" " + n.data);
			if (n.left != null)
				q.add(n.left);
			if (n.right != null)
				q.add(n.right);
		}
	}
}
class MyNode{
	int data;
	MyNode left;
	MyNode right;
	public MyNode(int data){
		this.data = data;
	}

}
