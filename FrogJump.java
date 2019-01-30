package ama01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FrogJump {
	
	
	public static void main(String[] args) {
		int[] stones= {0,1,3,5,6,8,12,17};
		System.out.println(canCross(stones));
	}
	 public static boolean canCross(int[] stones) {
	        HashMap<Integer, Set<Integer>> map = new HashMap<>();
	        for (int i = 0; i < stones.length; i++) {
	            map.put(stones[i], new HashSet<Integer>());
	        }
	        map.get(0).add(0);
	        for (int i = 0; i < stones.length; i++) {
	            for (int k : map.get(stones[i])) {
	            	System.out.println("k: "+k);
	                for (int step = k - 1; step <= k + 1; step++) {
	                	System.out.println("step: "+step);
	                    if (step > 0 && map.containsKey(stones[i] + step)) {
	                    	System.out.println("val: "+(stones[i] + step)+" "+map.containsKey(stones[i] + step)+" step: "+step);
	                        map.get(stones[i] + step).add(step);
	                    }
	                }
	            }
	        }
	        return map.get(stones[stones.length - 1]).size() > 0;
	    }
}
