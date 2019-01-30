package ama01;

import java.util.PriorityQueue;

public class PriortyQueueTest {
	
	PriorityQueue<String> pq= new PriorityQueue<String>(5,(a,b) -> a.length() - b.length());
	
	public static void main(String[] args) {
        PriorityQueue<String> pq= new PriorityQueue<String>(5, (a,b) -> a.length() - b.length());
       // or pq = new PriorityQueue<String>(5, Comparator.comparing(String::length));
        pq.add("Apple");
        pq.add("Zpple");
        pq.add("PineApple");
        pq.add("Custard Apple");
        while (pq.size() != 0)
        {
            System.out.println(pq.remove());
        }
    }

}
