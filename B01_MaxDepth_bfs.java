package ama01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
 public int val;
 public List<Node> children;
 public Node() {}
 public Node(int _val, List<Node> _children) {
     val = _val;
     children = _children;
 }
}
public class B01_MaxDepth_bfs {
	
	public static void main(String[] args) {
		
		List<Node> list5 = new ArrayList<>();
		List<Node> list6 = new ArrayList<>();
		Node node5 = new Node(5, list5);
		Node node6 = new Node(6, list6);
		List<Node> list1 = new ArrayList<>();
		list1.add(node5);
		list1.add(node5);
		
		Node node3 = new Node(3, list1);
		List<Node> list2 = new ArrayList<>();
		List<Node> list4 = new ArrayList<>();
		Node node2 = new Node(2, list2);
		Node node4 = new Node(4, list2);
		List<Node> list = new ArrayList<>();
		list.add(node3);
		list.add(node2);
		list.add(node4);
		Node node1 = new Node(1, list);
		System.out.println(maxDepth(node1));
	}
	
	public static int maxDepth(Node root) {
	    if(root == null) return 0;
	    
	    Queue<Node> queue = new LinkedList<>();
	    queue.offer(root);
	    
	    int depth = 0;
	    
	    while(!queue.isEmpty())
	    {
	        int size = queue.size();
	        
	        for(int i = 0; i < size; i++)
	        {
	            Node current = queue.poll();
	            for(Node child: current.children) queue.offer(child);
	        }
	        
	        depth++;
	    }
	    
	    return depth;
	}

}
