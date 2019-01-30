package ama01;

class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int x){
		this.val = x;
	}
}

public class DiameterOfBinaryTree {
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		
		System.out.println("val: "+diameter(node));
	}
	
	static int ans ;
	public static int diameter(TreeNode root) {
		ans =1;
		depth(root);
		System.out.println("==========");
		return ans-1;
	}
	
	public static int depth(TreeNode node) {
		if(node== null) return 0;
		System.out.println(node.val);
		int L = depth(node.left);
		int R = depth(node.right);
		ans = Math.max(ans, L+R+1);
		return Math.max(L, R)+1;
	}

}
