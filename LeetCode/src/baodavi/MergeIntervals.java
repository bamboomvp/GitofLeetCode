package baodavi;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
	
	public class Interval {
	     int start;
	     int end;
	     Interval() { start = 0; end = 0; }
	     Interval(int s, int e) { start = s; end = e; }
	}
	
	/*
The idea is to sort the intervals by their starting points. 
Then, we take the first interval and compare its end with the next intervals starts. 
As long as they overlap, we update the end to be the max end of the overlapping intervals. 
Once we find a non overlapping interval, we can add the previous "extended" interval and start over.

Sorting takes O(n log(n)) and merging the intervals takes O(n). So, the resulting algorithm takes O(n log(n)).
	 */
	public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1)	return intervals;
        
        // Sort by ascending starting point using an anonymous Comparator
        Collections.sort(intervals, new Comparator<Interval>(){
        	public int compare(Interval o1, Interval o2){
        		return Integer.compare(o1.start, o2.start);
        	}
        });
        
        List<Interval> result = new LinkedList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        for(Interval interval : intervals){
        	if(interval.start <= end){
        		// Overlapping intervals, move the end if needed
        		end = Math.max(end, interval.end);
        	}else{
        		// Disjoint intervals, add the previous one and reset bounds
        		result.add(new Interval(start, end));
        		start = interval.start;
        		end = interval.end;
        	}
        }
        
        // Add the last interval
        result.add(new Interval(start, end));
        return result;
    }
}
