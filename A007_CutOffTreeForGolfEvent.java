package ama01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class A007_CutOffTreeForGolfEvent {

		
		public static void main(String[] args) {
			
			List<Integer> list = new ArrayList<>();
			List<Integer> list2 = new ArrayList<>();
			List<Integer> list3 = new ArrayList<>();
			list.add(1);list.add(2);list.add(3);
			list2.add(0);list2.add(0);list2.add(4);
			list3.add(7);list3.add(6);list3.add(5);
			
			List<List<Integer>> list4 = new ArrayList<>();
			list4.add(list);list4.add(list2);list4.add(list3);
	 		
			System.out.println(cutOffTree(list4));
		}
		
		   static int[][] dir = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};

		    public static int cutOffTree(List<List<Integer>> forest) {
		        if (forest == null || forest.size() == 0) return 0;
		        int m = forest.size(), n = forest.get(0).size();

		        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

		        for (int i = 0; i < m; i++) {
		            for (int j = 0; j < n; j++) {
		            	System.out.println("aa: "+i+" "+j);
		                if (forest.get(i).get(j) > 1) {
		                	System.out.println("    "+i+" "+j+" : "+forest.get(i).get(j));
		                    pq.add(new int[] {i, j, forest.get(i).get(j)});
		                }
		            }
		            System.out.println();
		        }

		        int[] start = new int[2];
		        int sum = 0;
		        while (!pq.isEmpty()) {
		            int[] tree = pq.poll();
		            System.out.println("tree: "+tree[0]+" "+tree[1]);
		            int step = minStep(forest, start, tree, m, n);
		            System.out.println("step: "+step);
		            if (step < 0) return -1;
		            sum += step;

		            start[0] = tree[0];
		            start[1] = tree[1];
		        }

		        return sum;
		    }

		    private static int minStep(List<List<Integer>> forest, int[] start, int[] tree, int m, int n) {
		        int step = 0;
		        boolean[][] visited = new boolean[m][n];
		        Queue<int[]> queue = new LinkedList<>();
		        queue.add(start);
		        visited[start[0]][start[1]] = true;

		        while (!queue.isEmpty()) {
		            int size = queue.size();
		            for (int i = 0; i < size; i++) {
		                int[] curr = queue.poll();
		                if (curr[0] == tree[0] && curr[1] == tree[1]) return step;

		                for (int[] d : dir) {
		                    int nr = curr[0] + d[0];
		                    int nc = curr[1] + d[1];
		                    if (nr < 0|| nr >= m|| nc < 0|| nc >= n||forest.get(nr).get(nc) == 0 || visited[nr][nc]) continue;
		                    queue.add(new int[] {nr, nc});
		                    visited[nr][nc] = true;
		                }
		            }
		            step++;
		        }

		        return -1;
		    }
	
}
