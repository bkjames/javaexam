package ama01;

import java.util.Arrays;
import java.util.Comparator;


public class a042_MeetingRooms {
	
	static class Interval{
		int start;
		int end;
		Interval(){
			start=0;
			end=0;
		}
		Interval(int s, int e){
			this.start=s;
			this.end=e;
		}
	}

	
	public static void main(String[] args) {
		Interval in= new Interval(0,30);
		Interval in1= new Interval(5,10);
		Interval in2= new Interval(15,20);
		
		Interval[] intervals = {in, in1, in2};
		System.out.println(canAttendMeetings(intervals));
	}
	
	  public static boolean canAttendMeetings(Interval[] intervals) {
	    if(intervals == null) return false;
	    
	    Arrays.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval a, Interval b) {
				// TODO Auto-generated method stub
				return a.start- b.start;
			}
	    });
	    
	    for(int i=1; i< intervals.length; i++) {
	    	if(intervals[i].start < intervals[i-1].end)
	    		return false;
	    }
	    return true;
	    
	  }
	

}
