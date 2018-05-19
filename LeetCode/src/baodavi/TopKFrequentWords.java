package baodavi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
	
	private class WordFrequency{
		public String word;
		public int frequency;
		public WordFrequency(String word){
			this.word = word;
			this.frequency = 1;
		}
	}
	
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, WordFrequency> map = new HashMap<>();
        for(String word : words){
        	if(!map.containsKey(word)){
        		WordFrequency wf = new WordFrequency(word);
        		map.put(word, wf);
        	}else{
        		map.get(word).frequency += 1;
        	}
        }
        
        PriorityQueue<WordFrequency> queue = new PriorityQueue<>(k, new Comparator<WordFrequency>(){
			@Override
			public int compare(WordFrequency o1, WordFrequency o2) {
				if(o1.frequency != o2.frequency)	return o1.frequency - o2.frequency;
				else	return o2.word.compareTo(o1.word);
			}
        });
        
        for(WordFrequency f : map.values()){
        	queue.offer(f);
        	if(queue.size() > k){
        		queue.poll();
        	}
        }
        List<String> res = new ArrayList<>();
        while(!queue.isEmpty()){
        	res.add(0, queue.poll().word);
        }
        return res;
    }
}
