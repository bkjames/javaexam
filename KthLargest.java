package ama01;

import java.util.PriorityQueue;

public class KthLargest {

	public static void main(String[] args) {
		int k = 3;
		int[] arr = {4,5,8,2};
		KthLargest kk = new KthLargest(3, arr);
		System.out.println(kk.add(3));
		System.out.println(kk.add(5));
	}
        final PriorityQueue<Integer> q;
        final int k;

        public KthLargest(int k, int[] a) {
            this.k = k;
            q = new PriorityQueue<>(k);
            for (int n : a)
                add(n);
        }

        public int add(int n) {
        	System.out.println("n: "+n);
            if (q.size() < k)
                q.offer(n);
            else if (q.peek() < n) {
                q.poll();
                q.offer(n);
            }
            System.out.println("q.peek(): "+q.peek());
            return q.peek();
        }
    
}
