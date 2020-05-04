package TreeAndLinkedList_Problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
// Find ancestor / child nodes of a particular node in binary tree
/*
 * 			10
 * 		   /  \
 * 		  8   15
 * 		 / \    \
 * 		5   9    20
 * 
 * 
 * Stack -> 10 8 5 9 15 20
 * Queue (LinkedList)-> 10 8 15 5 9 20
 */
public class TreeProblems {
	public static void main(String[] args) {
		//Tree preparation...
		MyNode root = new MyNode(10, null, null);
		root.left = new MyNode(8, null, null);
		root.right = new MyNode(15, null, null);
		root.left.left = new MyNode(5, null, null);
		root.left.right = new MyNode(9, null, null);
		root.right.right = new MyNode(20, null, null);
		
		findAllAncestors(root);
		DFS(root); // to fine all the children of a node
		BFS(root);
		//InOrderTraverse(root);
	
		
		// Modify BST by all nodes which are having child with higher values from the parent
		//modifyBST(root);
		//BFS(root);
	}
	
	private static void InOrderTraverse(MyNode root) {
		if(root == null) return;
		InOrderTraverse(root.left);
		System.out.println("data " + root.data);
		InOrderTraverse(root.right);
	}

	static void modifyBST(MyNode root) {
		int sum = 0;
		modifyBSTUtil(root, sum);
	}

	static void modifyBSTUtil(MyNode root, int sum) {
		if (root == null)
			return;
		// Recur for right subtree
		modifyBSTUtil(root.right, sum);
		// Now *sum root->data to sum and update root->data
		// sum has sum of nodes in right subtree, add
		sum = sum + root.data;
		root.data = sum;
		// Recur for left subtree
		modifyBSTUtil(root.left, sum);
	}
	
	
	
	
	// This is very good example of finding all the ancestors from any node. Root has to be passed.
	private static void findAllAncestors(MyNode root) {
		List<Integer> list = new ArrayList<Integer>();
		boolean found = findAncestorPath(list, root, 9);
		if(found)
		{
			System.out.println("ancestor list contains " + list);
		}
	}
	public static boolean findAncestorPath(List<Integer> ancestors, MyNode root, int number) {
	    if (root == null)
	        return false;
	    int data = root.data;
	    if (data == number)
	        return true;
	    if (findAncestorPath(ancestors, root.left, number)) {
	        ancestors.add(data);
	        return true;
	    }
	    if (findAncestorPath(ancestors, root.right, number)) {
	        ancestors.add(data);
	        return true;
	    }
	    return false;
	}
	
	public static void DFS(MyNode root){
		System.out.println("****  DEPTH FIRST TRAVERSAL ****** ");
		if(root == null)    return;
        Stack<MyNode> res = new Stack<MyNode>();
        res.push(root);
        while(!res.isEmpty()){
            MyNode top = res.pop();
            System.out.print(top.data + " ");
            if(top.right != null)
                res.push(top.right);
            if(top.left!= null)
                res.push(top.left);
        }
        System.out.println("");
    }
	
	public static void BFS(MyNode root){
        System.out.println("****  BREDTH FIRST TRAVERSAL ****** ");
		if(root == null)    return;
        Queue<MyNode> res = new LinkedList<MyNode>(); // stack will not work here , remember stack for DFS and LinkedList(Queue) for BFS and order of adding into those DS.
        res.add(root);
        
        while(!res.isEmpty()){
            MyNode top = res.remove(); // poll cab be used.
            System.out.print(top.data + " ");
            if(top.left != null)
                res.add(top.left);
            if(top.right!= null)
                res.add(top.right);
        }
    }	
}

/*class MyNode 
{
	int data;
	MyNode left;
	MyNode right;
	public MyNode(int d , MyNode l , MyNode r)
	{
		data=d;
		left = l;
		right = r;
	}
}*/

// refer this also for 2D array and shortest path solution in java:-  https://medium.com/@manpreetsingh.16.11.87/shortest-path-in-a-2d-array-java-653921063884

