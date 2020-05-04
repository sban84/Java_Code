package TreeAndLinkedList_Problems;



import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/*
 * Given an array that represents Inorder Traversal, find all possible Binary Trees with the given Inorder traversal and print their preorder traversals.
 */
public class TreeProblems_1 {

	public static void main(String[] args) {
		
		int in[] = {4, 5, 7};
        int n = in.length;
        Vector<MyNode> trees = TreeProblems_1.getTrees(in, 0, n - 1);
        System.out.println("Preorder traversal of different "+
                           " binary trees are:");
        for (int i = 0; i < trees.size(); i++) {
            TreeProblems_1.preOrder(trees.get(i));
            System.out.println("");
        }
		//Map<Integer,Integer> map = new Hashtable<Integer,Integer>();
		//List<Integer> l = new Vector<Integer>();
	}
	static void preOrder(MyNode node) {
		if(node == null)
		{
			return;
		}
		System.out.print(node.data + " "    );
        preOrder(node.left);
        preOrder(node.right);
    }
	
	static void inOrder(MyNode node) {
		if(node == null)
		{
			return;
		}
		
        inOrder(node.left);
        System.out.print(node.data + " "    );
        inOrder(node.right);
    }
	
	
	static Vector<MyNode> getTrees(int arr[], int start, int end) {
		 
        // List to store all possible trees
        Vector<MyNode> trees= new Vector<MyNode>();
 
        /* if start > end then subtree will be empty so
         returning NULL in the list */
        if (start > end) {
            trees.add(null);
            return trees;
        }
 
        /* Iterating through all values from start to end
         for constructing left and right subtree
         recursively */
        for (int i = start; i <= end; i++) {
            /* Constructing left subtree */
            Vector<MyNode> ltrees = getTrees(arr, start, i - 1); 
             
            /* Constructing right subtree */
            Vector<MyNode> rtrees = getTrees(arr, i + 1, end); 
 
            /* Now looping through all left and right subtrees
             and connecting them to ith root below */
            for (int j = 0; j < ltrees.size(); j++) {
                for (int k = 0; k < rtrees.size(); k++) {
 
                    // Making arr[i] as root
                    MyNode node = new MyNode(arr[i],null,null);
 
                    // Connecting left subtree
                    node.left = ltrees.get(j);
 
                    // Connecting right subtree
                    node.right = rtrees.get(k);
 
                    // Adding this tree to list
                    trees.add(node);
                }
            }
        }
        return trees;
}
}

class MyNode{
	int data ;
	MyNode left;
	MyNode right;
	
	public  MyNode(int data, MyNode left, MyNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}