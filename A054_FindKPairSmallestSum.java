package ama01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class A054_FindKPairSmallestSum {
	
	 public static void main(String[] args) {
		 int[] nums1 = {1,7,11}, nums2 = {2,4,6};
		 int k = 3;
		 kSmallestPairs(nums1, nums2, k);
	}

	 
	 public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
	        List<int[]> rst = new ArrayList<>();
	        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
	            return rst;
	        }
	        
	        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] a, int[] b) {
					return (a[0]+a[1])-(b[0]-b[1]);

				}
	        });
	        
	        // Initialize the minHeap
	        // when offer the next element, we need to know the curr index of nums2.
	        // So the array is consist of: the element in nums1, the element in nums2, the curr element's index in nums2.
	        for (int i = 0; i < k && i < nums1.length; i++) {
	        	System.out.println(nums1[i]+" "+ nums2[0]+" "+ 0);
	            pq.offer(new int[]{nums1[i], nums2[0], 0});
	        }
	        System.out.println();
	        // poll the peak element (minElement currently), and offer the next element
	        while (k-- > 0 && !pq.isEmpty()) {
	            int[] cur = pq.poll();
	            rst.add(new int[]{cur[0], cur[1]});
	            // check the index of nums2 is out of bound or not
	            if (cur[2] == nums2.length - 1) {
	                continue;
	            }
	            System.out.println(cur[0]+" "+ (nums2[cur[2] + 1])+" "+( cur[2] + 1));
	            pq.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
	        }
	        
	        return rst;

	
	    }
}
//
//public class MyComparator implements Comparator<int[]> {
//    public int compare(int[] a, int[] b) {
//        return a[0] + a[1] - b[0] - b[1];
//    }
//}
//public List<int[]> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
//    PriorityQueue<int[]> que = new PriorityQueue<>(new MyComparator());
//    List<int[]> res = new ArrayList<>();
//    if(nums1.length==0 || nums2.length==0 || k==0) return res;
//    for(int i=0; i<nums1.length && i<k; i++) que.offer(new int[]{nums1[i], nums2[0], 0});
//    while(k-- > 0 && !que.isEmpty()){
//        int[] cur = que.poll();
//        res.add(new int[]{cur[0], cur[1]});
//        if(cur[2] == nums2.length-1) continue;
//        que.offer(new int[]{cur[0],nums2[cur[2]+1], cur[2]+1});
//    }
//    return res;
//}
//
//public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//    List<int[]> res = new ArrayList<int[]>();
//    if(nums1.length == 0 || nums2.length == 0 || k == 0) return res;
//    PriorityQueue<int[]> pq = new PriorityQueue<int[]>(1, new Comparator<int[]>(){
//        public int compare(int[] a, int[] b){
//            return (a[0]+a[1])-(b[0]+b[1]);
//        }
//    });
//    for(int i=0;i<nums1.length;i++){
//        for(int j=0;j<nums2.length;j++){
//            pq.offer(new int[]{nums1[i], nums2[j]});
//        }
//    }
//    for(int i=0;i<k;i++){
//        if(pq.isEmpty()) break;
//        res.add(pq.poll());
//    }
//    return res;
//}

//public List<int[]> kSmallestPairs(int[] A, int[] B, int k) {
//    List<int[]> res = new ArrayList<int[]>();
//    int n = A.length, m = B.length;
//    if (n == 0 || m == 0 || k == 0) 
//        return res;
//    PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x, y) -> A[x[0]] + B[x[1]] - A[y[0]] - B[y[1]]);
//    boolean[][] vis = new boolean[n][m];
//    pq.offer(new int[]{0, 0});
//    vis[0][0] = true;
//    int x = 0, y = 0;
//    while (k-- > 0 && !pq.isEmpty()) {
//        int[] cur = pq.poll();
//        x = cur[0];
//        y = cur[1];
//        res.add(new int[]{A[x], B[y]});
//        if (x + 1 < n && !vis[x + 1][y]) {
//            pq.offer(new int[]{x + 1, y});
//            vis[x + 1][y] = true;
//        }
//        if (y + 1 < m && !vis[x][y + 1]) {
//            pq.offer(new int[]{x, y + 1});
//            vis[x][y + 1] = true;
//        }
//    }
//    return res;
//}
//
////Java heap storing pair
//
//public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//    List<int[]> res = new ArrayList<>();
//    if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;
//    PriorityQueue<int[]> heap = new PriorityQueue<>((int[] a, int[] b) -> {
//        return nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]];
//    });
//
//    heap.add(new int[]{0, 0});
//    while (k > 0 && !heap.isEmpty()) {
//        int[] cur = heap.poll();
//        res.add(new int[]{nums1[cur[0]], nums2[cur[1]]});
//        if (cur[0] == 0 && cur[1] + 1 < nums2.length) {
//            heap.add(new int[]{0, cur[1] + 1});
//        }
//        if (cur[0] + 1 < nums1.length) {
//            heap.add(new int[]{cur[0] + 1, cur[1]});
//        }
//        k--;
//    }
//    return res;
//}
//
//
////PriorityQueue 9ms without helper class
//public List<int[]> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
//    List<int[]> res = new LinkedList<>();
//    if(nums1==null || nums1.length==0 || nums2==null || nums2.length==0) {
//        return res;
//    }
//    
//    // index pair
//    PriorityQueue<int[]> minQ = new PriorityQueue<>(new Comparator<int[]>(){
//        public int compare(int[] pair1, int[] pair2) {
//            return (nums1[pair1[0]]+nums2[pair1[1]])-(nums1[pair2[0]]+nums2[pair2[1]]);
//        }
//        
//    });
//    
//    
//    minQ.offer(new int[]{0, 0});
//    
//    while (k>0 && !minQ.isEmpty()) {
//        int[] pair=minQ.poll();
//        int i = pair[0];
//        int j = pair[1];
//        res.add(new int[]{nums1[i], nums2[j]});
//        k--;
//        
//        if(j+1<nums2.length) {
//            minQ.offer(new int[]{i, j+1});
//        }
//        
//        if(j==0 && i+1<nums1.length){ 
//            minQ.offer(new int[] {i+1, 0});
//        }
//
//    }
//    
//    
//    return res;
//}
////BFS
//public class Solution {
//    final int[][] neighbors = {{0, 1}, {1, 0}};
//    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//        List<int[]> list = new ArrayList<>();
//        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0) {
//            return list;
//        }
//        int m = nums1.length, n = nums2.length;
//        boolean[][] visited = new boolean[m][n];
//        Queue<Pair> minHeap = new PriorityQueue<>();
//        minHeap.offer(new Pair(0, 0, nums1[0] + nums2[0]));
//        visited[0][0] = true;
//        while (k > 0 && !minHeap.isEmpty()) {
//            Pair min = minHeap.poll();
//            list.add(new int[] {nums1[min.row], nums2[min.col]});
//            k--;
//            for (int[] neighbor : neighbors) {
//                int row1 = min.row + neighbor[0];
//                int col1 = min.col + neighbor[1];
//                if (row1 < 0 || row1 == m || col1 < 0 || col1 == n || visited[row1][col1]) {
//                    continue;
//                }
//                visited[row1][col1] = true;
//                minHeap.offer(new Pair(row1, col1, nums1[row1] + nums2[col1]));
//            }
//        }
//        return list;
//    }
//}
//
//class Pair implements Comparable<Pair> {
//    int row;
//    int col;
//    int value;
//    
//    Pair(int row, int col, int value) {
//        this.row = row;
//        this.col = col;
//        this.value = value;
//    }
//    
//    public int compareTo(Pair other) {
//        return value - other.value;
//    } 
//}
