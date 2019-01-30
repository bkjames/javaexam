package ama01;
import java.util.HashMap;

class Node{
    int key;
    int value;
    Node pre;
    Node next;
 
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

public class LRUCache02 {
	
	 public static void main(String[] args) throws Exception{
		 LRUCache02 cache = new LRUCache02(2);
	        cache.set(1, 1);
	        cache.set(2, 2);
	        System.out.println(cache.get(1));
	        cache.set(3,3);
	        System.out.println(cache.get(2));
	        cache.set(4, 4);
	        System.out.println(cache.get(1));
	        System.out.println(cache.get(3));
	        System.out.println(cache.get(4));
//		   cache.set(1, 1);
//		   cache.set(2, 2);
//		   cache.get(1);       // returns 1
//		   cache.set(3, 3);    // evicts key 2
//		   cache.get(2);       // returns -1 (not found)
//		   cache.set(4, 4);    // evicts key 1
//		   cache.get(1);       // returns -1 (not found)
//		   cache.get(3);       // returns 3
//		   cache.get(4);       // returns 4
    }
	  
    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head=null;
    Node end=null;
 
    public LRUCache02(int capacity) {
        this.capacity = capacity;
    }
 
    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
 
        return -1;
    }
 
    public void remove(Node n){
        if(n.pre!=null){
            n.pre.next = n.next;
        }else{
            head = n.next;
        }
 
        if(n.next!=null){
            n.next.pre = n.pre;
        }else{
            end = n.pre;
        }
 
    }
 
    public void setHead(Node n){
        n.next = head;
        n.pre = null;
 
        if(head!=null)
            head.pre = n;
 
        head = n;
 
        if(end ==null)
            end = head;
    }
 
    public void set(int key, int value) {
        if(map.containsKey(key)){
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        }else{
            Node created = new Node(key, value);
            if(map.size()>=capacity){
                map.remove(end.key);
                remove(end);
                setHead(created);
 
            }else{
                setHead(created);
            }    
 
            map.put(key, created);
        }
    }
}