package ama01;

import java.util.PriorityQueue;
import java.util.Queue;

public class A013_KClosestPointToOrigin {
	
	public static void main(String[] args) {
		int[][] points= {{1,3},{-2,2}};
		int k =1;
//		int[][] points= {{3,3},{5,-1},{-2,4}};
//		int k =2;
		int[][] result= new A013_KClosestPointToOrigin().kClosest(points, k);
		print(result);
	}
	public static void print(int[][] result) {
		int m = result.length;
		int n = result[0].length;
		for(int i=0; i<m ; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(result[i][j]);
			}
		}
	}
	
	public int[][] kClosest(int[][] points, int k){
		Queue<int[]> queue = new PriorityQueue<>((a,b)-> (a[0]*a[0]+a[1]*a[1])-(b[0]*b[0]+b[1]*b[1]));
		int[][] res = new int[k][2];
		int index =0;
		
		for(int[] arr: points) {
			queue.add(arr);
		}
		
		while(index < k) {
			res[index] =queue.poll();
			index++;
		}
		return res;
	}

}
