package ama01;


import java.util.HashSet;
import java.util.Set;


public class A055_TwoSum4Bst {

static class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int x){
		this.val = x;
	}
}
	public static void main(String[] args) {
		TreeNode node = new TreeNode(5);
		node.left = new TreeNode(3);
		node.left.left = new TreeNode(2);
		node.left.right = new TreeNode(4);
		node.right = new TreeNode(6);
		node.right.right = new TreeNode(7);
		int k =9;
		A055_TwoSum4Bst a = new A055_TwoSum4Bst();
		a.findTarget(node, k);
	}
	    public boolean findTarget(TreeNode root, int k) {
	        Set < Integer > set = new HashSet();
	        return find(root, k, set);
	    }
	    public boolean find(TreeNode root, int k, Set < Integer > set) {
	        if (root == null)
	            return false;
	        if (set.contains(k - root.val))
	            return true;
	        set.add(root.val);
	        return find(root.left, k, set) || find(root.right, k, set);
	    }
	
}
