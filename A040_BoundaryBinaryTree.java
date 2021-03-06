package ama01;

import java.util.ArrayList;
import java.util.List;

class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int x){
		this.val = x;
	}
}
public class A040_BoundaryBinaryTree {
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left=new TreeNode(2);
		node.left.left= new TreeNode(4);
		node.left.right= new TreeNode(5);
		node.left.right.left= new TreeNode(7);
		node.left.right.right= new TreeNode(8);
		
		node.right = new TreeNode(3);
		node.right.left = new TreeNode(6);
		node.right.left.left = new TreeNode(9);
		node.right.left.right = new TreeNode(10);
		
		A040_BoundaryBinaryTree bb = new A040_BoundaryBinaryTree();
		List<Integer> list = bb.boundaryOfBinaryTree(node);
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	List<Integer> nodes = new ArrayList<>(1000);
	public  List<Integer> boundaryOfBinaryTree(TreeNode root) {
	    
	    if(root == null) return nodes;

	    nodes.add(root.val);
	    leftBoundary(root.left);
	    leaves(root.left);
	    leaves(root.right);
	    rightBoundary(root.right);
	    
	    return nodes;
	}
	public void leftBoundary(TreeNode root) {
	    if(root == null || (root.left == null && root.right == null)) return;
	    nodes.add(root.val);
	    if(root.left == null) leftBoundary(root.right);
	    else leftBoundary(root.left);
	}
	public void rightBoundary(TreeNode root) {
	    if(root == null || (root.right == null && root.left == null)) return;
	    if(root.right == null)rightBoundary(root.left);
	    else rightBoundary(root.right);
	    nodes.add(root.val); // add after child visit(reverse)
	}
	public void leaves(TreeNode root) {
	    if(root == null) return;
	    if(root.left == null && root.right == null) {
	        nodes.add(root.val);
	        return;
	    }
	    leaves(root.left);
	    leaves(root.right);
	}
	
	
	  public List<Integer> boundaryOfBinaryTree(TreeNode root) {
	        //corner case
	        List<Integer> list = new ArrayList<>();
	        if (root == null) {
	            return list;
	        }

	        list.add(root.val);

	        dfs(root.left, true, false, list);//left half tree
	        dfs(root.right, false, true, list);//right half tree

	        return list;
	    }

	    //PreOrder on the left half tree to fetch left Border elements, InOrder on the left and right half tree to fetch leaf elements PostOrder on the right half tree to fetch right Border elements 
	    private void dfs(TreeNode root, boolean isLeftBound, boolean isRightBound, List<Integer> list) {
	        //base case
	        if (root == null) {
	            return;
	        }

	        //take care of leftBorder elements in preOrder
	        if (isLeftBound) {
	            list.add(root.val);
	        }

	        dfs(root.left, isLeftBound, isRightBound && root.right == null, list);

	        //take care of leaf nodes in AnyOrder, I just use InOrder
	        if (!isLeftBound && !isRightBound && root.left == null && root.right == null) {
	            list.add(root.val);
	        }

	        dfs(root.right, isLeftBound && root.left == null, isRightBound, list);

	        //take care of rightBorder elements in postOrder
	        if (isRightBound) {
	            list.add(root.val);
	        }
	    }
}
