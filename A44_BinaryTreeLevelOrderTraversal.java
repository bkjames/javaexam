package ama01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int x){
		this.val= x;
	}
}
public class A44_BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(9);
		node.right = new TreeNode(20);
		node.right.left = new TreeNode(15);
		node.right.right = new TreeNode(7);
		levelOrder(node);
		
	}
	
	
	 public static List<List<Integer>> levelOrder(TreeNode root) {
	       List<List<Integer>> result = new ArrayList<List<Integer>>();
	       
	       if(root == null){
	          return result;
	       }
	       
	       Queue<TreeNode> queue = new LinkedList<TreeNode>();
	       queue.offer(root);
	       
	       int curL = 0;
	       while(!queue.isEmpty()){
	           List<Integer> levelRs = new ArrayList<Integer>(); 
	           curL = queue.size();
	           for(int i=0;i<curL;i++){
	               TreeNode peek = queue.poll();
	               levelRs.add(peek.val);
	               if(peek.left!=null){
	                   queue.offer(peek.left);
	               }
	               if(peek.right!=null){
	                   queue.offer(peek.right);
	               }
	           }
	           result.add(levelRs);
	       }
	       
	       return result;
	    }  
	
//	public List<List<Integer>> levelOrder(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
//        
//        if(root == null) return wrapList;
//        
//        queue.offer(root);
//        while(!queue.isEmpty()){
//            int levelNum = queue.size();
//            List<Integer> subList = new LinkedList<Integer>();
//            for(int i=0; i<levelNum; i++) {
//                if(queue.peek().left != null) queue.offer(queue.peek().left);
//                if(queue.peek().right != null) queue.offer(queue.peek().right);
//                subList.add(queue.poll().val);
//            }
//            wrapList.add(subList);
//        }
//        return wrapList;
//    }
}
