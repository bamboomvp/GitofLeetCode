package baodavi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
	
	private class Frequency{
		public int num;
		public int frequency;
		public Frequency(int num){
			this.num = num;
			this.frequency = 1;
		}
	}
	
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Frequency> map = new HashMap<>();
        for(int num : nums){
        	if(!map.containsKey(num)){
        		Frequency f = new Frequency(num);
        		map.put(num, f);
        	}else{
        		map.get(num).frequency += 1;
        	}
        }
        PriorityQueue<Frequency> queue = new PriorityQueue<>(k, new Comparator<Frequency>(){
			@Override
			public int compare(Frequency o1, Frequency o2) {
				return o1.frequency - o2.frequency;
			}
        });
        for(Frequency f : map.values()){
        	queue.offer(f);
        	if(queue.size() > k){
        		queue.poll();
        	}
        }
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
        	res.add(queue.poll().num);
        }
        return res;
    }
}
