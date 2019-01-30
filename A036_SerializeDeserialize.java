package ama01;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import Ama9.TreeNode;

//class TreeNode {
//	int val;
//	TreeNode left;
//	TreeNode right;
//	TreeNode(int x) { val = x; }
//}



public class A036_SerializeDeserialize {

	
	public static void main (String[] args) throws java.lang.Exception
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		String serial = serialize(root);
		System.out.println(serial);
		TreeNode res = deserialize(serial);
//		printLeafNodes(res);
		if (res == null) System.out.println("null");
		else System.out.println(res.val);
	}


		private static final String spliter = ",";
	    private static final String NN = "X";

	    // Encodes a tree to a single string.
	    public static String serialize(TreeNode root) {
	        StringBuilder sb = new StringBuilder();
	        buildString(root, sb);
	        return sb.toString();
	    }

	    private static void buildString(TreeNode node, StringBuilder sb) {
	        if (node == null) {
	            sb.append(NN).append(spliter);
	        } else {
	            sb.append(node.val).append(spliter);
	            buildString(node.left, sb);
	            buildString(node.right,sb);
	        }
	    }
	    // Decodes your encoded data to tree.
	    public static TreeNode deserialize(String data) {
	        Deque<String> nodes = new LinkedList<>();
	        nodes.addAll(Arrays.asList(data.split(spliter)));
	        return buildTree(nodes);
	    }
	    
	    private static TreeNode buildTree(Deque<String> nodes) {
	        String val = nodes.remove();
	        if (val.equals(NN)) return null;
	        else {
	            TreeNode node = new TreeNode(Integer.valueOf(val));
	            node.left = buildTree(nodes);
	            node.right = buildTree(nodes);
	            return node;
	        }
	    }
	    
		public static void printLeafNodes(TreeNode node) {
		    // base case
		    if (node == null) {
		      return;
		    }

		    if (node.left == null && node.right == null) {
		      System.out.printf("%d ", node.val);
		    }

		    printLeafNodes(node.left);
		    printLeafNodes(node.right);
		  }
	
}
