package ama01;



import java.util.HashMap;
import java.util.Map;

public class A093_KDiffPair {
	
	public static void main(String[] args) {
		int[] input =  {3, 1, 4, 1, 5};
		int k = 2;
		System.out.println(findPairs(input, k));
	}
	
//	k<0 cannot happen because of the absolute difference condition; so return 0;
//	HashMap for O(n) runtime but O(n) additional space
//	frequency conditions for this problem /no duplicates in results
//	a.1) Handled by going over the HashMap so no two values visited again
//	a.2) by not considering similar elements again (twice) by reducing their frequency when k=0
//	For twosum you find difference with k here you find addition with k because this kdiff
	
	
	 public static int findPairs(int[] nums, int k) {
	        if (k < 0)   return 0;
	        HashMap<Integer,Integer> freqmap = new HashMap<Integer,Integer>();
	        int count = 0;
	        for(int num:nums){
	            int f = (int)freqmap.getOrDefault(num, 0)+1;
	            freqmap.put(num, f);
	        }
	        for (Integer key : freqmap.keySet()) {
	            int a = (int)key;
	            int b = a + k;
	            if(!freqmap.containsKey(b)) continue;
	            int bfreq = freqmap.get(b);
	            int minfreq = a==b ? 2:1;
	            if(bfreq>=minfreq ){
	                count++;
	                freqmap.put(a,1);
	            }
	        }
	        return count;
	    }
	 
	 
	
	public static int findPairs2(int[] nums, int k) {
		
	
        if (nums == null || nums.length == 0 || k < 0)   return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	
        	System.out.println(entry.getKey()+" "+entry.getValue());
            if (k == 0) {
                //count how many elements in the array that appear more than twice.
                if (entry.getValue() >= 2) {
                    count++;
                } 
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }
        
        return count;
    }

}
