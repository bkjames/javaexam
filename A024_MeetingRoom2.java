package ama01;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Interval{
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

class TimePoint implements Comparable<TimePoint> {
    int time, flag;

    TimePoint(int time, int flag) {
        this.time = time;
        this.flag = flag;
    }


    public int compareTo(TimePoint p) {
        return this.time - p.time == 0 ? this.flag - p.flag : this.time - p.time;
    }
}
public class A024_MeetingRoom2 {

		
		public static void main(String[] args) {
			int[][] nums = {{0,30},{5,10},{15,20}};
			Interval in = new Interval(0,30);
			Interval in2 = new Interval(5,10);
			Interval in3 = new Interval(15,20);
//			List<Interval> list = new ArrayList<>();
//			list.add(in);
//			list.add(in2);
//			list.add(in3);
//			System.out.println(minMeetingRooms(list));
			
			Interval[] internalArr = {in, in2, in3};
			System.out.println(minMeetingRooms(internalArr));
			
//			Interval[] intervals = {in, in2,in3};
//			System.out.println(minMeetingRooms2(intervals));
			
		}
		

		  public static int minMeetingRooms(Interval[] intervals) {

		    // Check for the base case. If there are no intervals, return 0
		    if (intervals.length == 0) {
		      return 0;
		    }

		    // Min heap
		    PriorityQueue<Integer> allocator =new PriorityQueue<Integer>(intervals.length,new Comparator<Integer>() {
		              public int compare(Integer a, Integer b) {
		                return a - b;
		              }
		            });

		    // Sort the intervals by start time
		    Arrays.sort(intervals, new Comparator<Interval>() {
		          public int compare(Interval a, Interval b) {
		            return a.start - b.start;
		          }
		        });

		    // Add the first meeting
		    allocator.add(intervals[0].end);

		    // Iterate over remaining intervals
		    for (int i = 1; i < intervals.length; i++) {

		      // If the room due to free up the earliest is free, assign that room to this meeting.
		      if (intervals[i].start >= allocator.peek()) {
		        allocator.poll();
		      }

		      // If a new room is to be assigned, then also we add to the heap,
		      // If an old room is allocated, then also we have to add to the heap with updated end time.
		      allocator.add(intervals[i].end);
		    }

		    // The size of the heap tells us the minimum rooms required for all the meetings.
		    return allocator.size();
		  }
		

		
		public static int minMeetingRooms2(Interval[] intervals) {
		    if(intervals==null||intervals.length==0)
		        return 0;
		 
		    Arrays.sort(intervals, new Comparator<Interval>(){
		        public int compare(Interval i1, Interval i2){
		            return i1.start-i2.start;
		        }
		    });
		 
		    PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		    int count=1;
		    queue.offer(intervals[0].end);
		 
		    for(int i=1; i<intervals.length; i++){
		        if(intervals[i].start<queue.peek()){
		            count++;
		 
		        }else{
		            queue.poll();
		        }
		 
		        queue.offer(intervals[i].end);
		    }
		 
		    return count;
		}
		
		public static int minMeetingRooms(List<Interval> intervals) {
	        List<TimePoint> list = new LinkedList<>();
	        for (Interval interval :intervals) {
	            list.add(new TimePoint(interval.start, 1));
	            list.add(new TimePoint(interval.end, -1));
	        }
	        Collections.sort(list);

	        int rst = 0;
	        int count = 0;
	        for (TimePoint p : list) {
	            count += p.flag;
	            rst = Math.max(rst, count);
	        }
	        return rst;
	    }

	   
	}


//252. Meeting Rooms
//
//public boolean canAttendMeetings(Interval[] intervals) {
//    Map<Integer, Integer> map = new TreeMap<>();
//    for (Interval itl : intervals) {
//        map.put(itl.start, map.getOrDefault(itl.start, 0) + 1);
//        map.put(itl.end, map.getOrDefault(itl.end, 0) - 1);
//    }
//    int room = 0; 
//    for (int v : map.values()) {
//        room += v; 
//        if (room > 1) return false; 
//    }
//    return true; 
//}
//253. Meeting Rooms II
//
//public int minMeetingRooms(Interval[] intervals) {
//    Map<Integer, Integer> map = new TreeMap<>();
//    for (Interval itl : intervals) {
//        map.put(itl.start, map.getOrDefault(itl.start, 0) + 1);
//        map.put(itl.end, map.getOrDefault(itl.end, 0) - 1);
//    }
//    int room = 0, k = 0; 
//    for (int v : map.values()) 
//        k = Math.max(k, room += v); 
//    
//    return k; 
//}
//731. My Calendar II
//
//private TreeMap<Integer, Integer> map = new TreeMap<>();
//public boolean book(int s, int e) {
//    map.put(s, map.getOrDefault(s, 0) + 1); 
//    map.put(e, map.getOrDefault(e, 0) - 1); 
//	
//    int cnt = 0, k = 0;
//    for (int v : map.values()) { 
//        k = Math.max(k, cnt += v);
//        if (k > 2) { 
//            map.put(s, map.get(s) - 1); 
//            map.put(e, map.get(e) + 1); 
//            return false; 
//        }
//    }
//    return true;
//}
//
//732. My Calendar III
//
//Map<Integer, Integer> map = new TreeMap<>();
//public int book(int start, int end) {
//    map.put(start, map.getOrDefault(start, 0) + 1);
//    map.put(end, map.getOrDefault(end, 0) - 1);
//    
//    int cnt = 0, k = 0;  
//    for (int v : map.values()) {
//        cnt += v;
//        k = Math.max(k, cnt);
//    }
//    return k; 
//}
//
//A bit more complicated:
//56. Merge Interval
//
// public List<Interval> merge(List<Interval> intervals) {
//    Map<Integer, Integer> map = new TreeMap<>();
//    for (Interval itl : intervals) {
//        map.put(itl.start, map.getOrDefault(itl.start, 0) + 1);
//        map.put(itl.end, map.getOrDefault(itl.end, 0) - 1);
//    }
//    List<Interval> list = new LinkedList<>(); 
//    int start = 0, cnt = 0; 
//    for (Map.Entry<Integer, Integer> e : map.entrySet()) {
//        if (cnt == 0) start = e.getKey();
//		// if cnt is 0, that means a full interval has been completed. 
//        if ((cnt += e.getValue()) == 0) 
//			list.add(new Interval(start, e.getKey()));
//    }
//    return list;
//}



//public int minMeetingRooms(Interval[] intervals) {
//    PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
//    for (Interval i : intervals) {
//        q.offer(new int[] {i.start, 1});
//        q.offer(new int[] {i.end, -1});
//    }
//    int max = 0, cur = 0;
//    while(!q.isEmpty())
//        max = Math.max(cur += q.poll()[1], max);
//    return max;
//} 
//Greedy way, much faster than min-heap, while loop is the same as the merge operation of merge-sort.
//
//public int minMeetingRooms(Interval[] intervals) {
//    int[] starts = new int[intervals.length], ends = new int[intervals.length];
//    for (int i = 0; i < intervals.length; i++) {
//        starts[i] = intervals[i].start;
//        ends[i] = intervals[i].end;
//    }
//    Arrays.sort(starts);
//    Arrays.sort(ends);
//    int i = 0, j = 0, max = 0, cur = 0;
//    while (i < starts.length || j < ends.length) {
//        if (i >= starts.length) {
//            break;
//        } else if (starts[i] < ends[j]) {
//            cur += 1; i++;
//        } else {
//            cur -= 1; j++;
//        }
//        max = Math.max(cur, max);
//    }
//    return max;
//}