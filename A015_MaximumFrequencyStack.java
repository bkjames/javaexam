package ama01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class A015_MaximumFrequencyStack {

	public static void main(String[] args) {
		
		A015_MaximumFrequencyStack a = new  A015_MaximumFrequencyStack();
		a.push(5);
		a.push(7);
		a.push(5);
		a.push(7);
		a.push(4);
		a.push(5);
		a.pop();
		a.pop();
		a.pop();
		a.pop();
		
	}
	    List<Stack<Integer>> bucket;
	    HashMap<Integer, Integer> map;
	    
	    public A015_MaximumFrequencyStack() {
	        bucket = new ArrayList<>();
	        map = new HashMap<>();
	    }
	    
	    public void push(int x) {
	        map.put(x, map.getOrDefault(x, 0) + 1);
	        int freq = map.get(x);
	        if (freq - 1 >= bucket.size()) {
	            bucket.add(new Stack<Integer>());
	        }
	        bucket.get(freq - 1).add(x);
	    }
	    
	    public int pop() {
	        int freq = bucket.size();
	        int x = bucket.get(freq - 1).pop();
	        if (bucket.get(freq - 1).isEmpty()) bucket.remove(bucket.size() - 1);
	        
	        map.put(x, map.get(x) - 1);
	        if (map.get(x) == 0) map.remove(x);
	        
	        return x;
	    }
}
