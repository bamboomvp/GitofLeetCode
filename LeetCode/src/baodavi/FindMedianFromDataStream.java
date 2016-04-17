package baodavi;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream {
	
	// max heap
	Queue<Integer> smallHalf = new PriorityQueue<Integer>(5, Collections.reverseOrder());
	
	// min heap
	Queue<Integer> bigHalf = new PriorityQueue<Integer>(5);	
	
    // Adds a number into the data structure.
    public void addNum(int num) {
    	if(bigHalf.size() == 0){
    		bigHalf.add(num);
    		return;
    	}
    	
    	if(num >= bigHalf.peek()){
    		bigHalf.add(num);
    		if(bigHalf.size() == smallHalf.size() + 2){
    			smallHalf.add(bigHalf.remove());
    		}
    	}else{
    		smallHalf.add(num);
    		if(smallHalf.size() == bigHalf.size() + 1){
    			bigHalf.add(smallHalf.remove());
    		}
    	}
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(smallHalf.size() == bigHalf.size()){
        	return (smallHalf.peek() + bigHalf.peek()) / 2.;
        }else{
        	return bigHalf.peek();
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();