package onlineTest;

import java.util.LinkedList;
import java.util.Queue;


/**
 * Program to convert any array to binary tree 
 * @author sban
 *
 */


public class TreeProblem_3 {
	
	public static void main(String[] args) {
		//String[] input = new String[]{"D1","D2","D3","C1"," "," ","C2"};
		String[] input = new String[]{"1","2","5","10"," "," ","20"};
		TreeNode tree = arrayToTree(input);
		inOrder(tree);
		BFS(tree);
	}
	
	public static void inOrder(TreeNode node) {
		if(node == null) return ;
		
		inOrder(node.left);
		System.out.print(node.val +" ");
		inOrder(node.right);
		
	}
	public static TreeNode arrayToTree(String[] input){
	    TreeNode root = createTreeNode(input,0);
	    return root;
	}

	private static TreeNode createTreeNode(String[] input, int k){
	    if(k<input.length){
	    	String value = input[k];
	        if(value!=null){
	            TreeNode t = new TreeNode(value);
	            t.left = createTreeNode(input, k*2+1);
	            t.right = createTreeNode(input, k*2+2);
	            return t;
	        }
	    }
	    return null;
	}
	
	
	public static void BFS(TreeNode root){
        System.out.println("****  BREDTH FIRST TRAVERSAL ****** ");
		if(root == null)    return;
        Queue<TreeNode> res = new LinkedList<TreeNode>();
        res.add(root);
        while(!res.isEmpty()){
            TreeNode top = res.poll();
            if(top.val==" ")
            {
            	System.out.print("NULL" + "-");
            }
            else
            {
            	System.out.print(top.val + "-");
            }
            	
            if(top.left != null)
                res.add(top.left);
            if(top.right!= null)
                res.add(top.right);
        }
    }

}

class TreeNode {
    public TreeNode left, right;
    public String val;

    public TreeNode(String val) {
        this.val = val;
    }
}


