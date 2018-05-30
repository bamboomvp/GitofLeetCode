package baodavi;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class QueueReconstructionByHeight {
	
	class PairComp implements Comparator<int[]> {
		public int compare(int[] p1, int[] p2){
			int compHeight = Integer.compare(p2[0], p1[0]);
			return compHeight == 0 ? Integer.compare(p1[1], p2[1]) : compHeight;
		}
	}
	
    public int[][] reconstructQueue(int[][] people) {
        LinkedList<int[]> list = new LinkedList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(1, new PairComp());
        for(int[] ppl : people){
        	queue.offer(ppl);
        }
        while(!queue.isEmpty()){
        	int[] pair = queue.poll();
        	list.add(pair[1], pair);
        }
        int[][] ret = new int[people.length][];
        for(int i = 0; i < list.size(); i++){
        	ret[i] = list.get(i);
        }
        return ret;
    }
}
