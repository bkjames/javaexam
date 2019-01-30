package ama01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;




public class A024_MeetingRoom2_leet {
	
	static class Interval{
		int start;
		int end;
		Interval(){
			start=0;
			end=0;
		}
		Interval(int s, int e){
			start=s;
			end=e;
		}
	}

	public static void main(String[] args) {
		int[][] nums = {{15,20},{0,30},{5,10}};
		Interval in = new Interval(0,30);
		Interval in2 = new Interval(5,10);
		Interval in3 = new Interval(15,20);
		
//		[[7,10],[2,4]]
		Interval in4 = new Interval(7,10);
		Interval in5 = new Interval(2,4);
//		List<Interval> list = new ArrayList<>();
//		list.add(in);
//		list.add(in2);
//		list.add(in3);
//		System.out.println(minMeetingRooms(list));
		
//		Interval[] internalArr = {in, in2, in3};
		Interval[] internalArr = {in4, in5};
		System.out.println(minMeetingRooms(internalArr));
		
//		Interval[] intervals = {in, in2,in3};
//		System.out.println(minMeetingRooms2(intervals));
		
	}
	
	public static int minMeetingRooms(Interval[] intervals) {
	    if (intervals == null || intervals.length == 0)
	        return 0;
	        
	    // Sort the intervals by start time
	    Arrays.sort(intervals, new Comparator<Interval>() {
	        public int compare(Interval a, Interval b) { return a.start - b.start; }
	    });
	    
	    // Use a min heap to track the minimum end time of merged intervals
	    PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
	        public int compare(Interval a, Interval b) { return a.end - b.end; }
	    });
	    
	    // start with the first meeting, put it to a meeting room
	    heap.offer(intervals[0]);
	    
	    for (int i = 1; i < intervals.length; i++) {
	        // get the meeting room that finishes earliest
	        Interval interval = heap.poll();
	        System.out.println(interval.start);
	        
	        if (intervals[i].start >= interval.end) {
	            // if the current meeting starts right after 
	            // there's no need for a new room, merge the interval
	            interval.end = intervals[i].end;
	        } else {
	            // otherwise, this meeting needs a new room
	            heap.offer(intervals[i]);
	        }
	        
	        // don't forget to put the meeting room back
	        heap.offer(interval);
	    }
	    
	    return heap.size();
	}
	
	 public static int minMeetingRooms2(Interval[] intervals) {
	        if (intervals.length == 0){
	            return 0;
	        }
	        //Sort the intervals by start time
	        Arrays.sort(intervals, (a,b) -> a.start - b.start);
	        
	        PriorityQueue<Interval> heap = new PriorityQueue<>((a,b) -> a.end - b.end);
	        
	        heap.offer(intervals[0]);
	        
	        for (int i = 1; i < intervals.length; i++){
	            Interval interval = heap.poll();
	            if (intervals[i].start >= interval.end){
	                heap.offer(intervals[i]);
	            }
	            else {
	                heap.offer(interval);
	                heap.offer(intervals[i]);
	            }
	        }
	        return heap.size();
	    }
}
