package baodavi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
    	
    	int[][] edges = new int[N][N];
    	for(int m = 0; m < N; m++){
    		for(int n = 0; n < N; n++){
    			edges[m][n] = -1;
    		}
    	}
    	for(int[] time : times){
    		edges[time[0] - 1][time[1] - 1] = time[2];
    	}
    	
    	Integer[] dijkstra = new Integer[N];
    	Arrays.fill(dijkstra, Integer.MAX_VALUE);
    	dijkstra[K - 1] = 0;
    	Set<Integer> visited = new HashSet<>();
    	List<Integer> fringe = new ArrayList<>();
    	fringe.add(K - 1);
    	while(!fringe.isEmpty()){
    		// pick the shortest next 
    		int picked = networkDelayTimeHelper(dijkstra, fringe);
    		int pickedNode = fringe.get(picked);
    		visited.add(pickedNode);
    		fringe.remove(picked);
    		for(int i = 0; i < N; i++){
    			if(edges[pickedNode][i] != -1 && !visited.contains(i)){
    				dijkstra[i] = Math.max(dijkstra[i], dijkstra[pickedNode] + edges[pickedNode][i]);
    				if(!fringe.contains(i)){
    					fringe.add(i);
    				}
    			}
    		}
    	}
    	
    	int maxDist = Collections.max(Arrays.asList(dijkstra));
    	return maxDist == Integer.MAX_VALUE ? -1 : maxDist;
    }
    
    private int networkDelayTimeHelper(Integer[] dijkstra, List<Integer> fringe){
    	int minIdx = 0;
    	int minVal = dijkstra[fringe.get(0)];
    	for(int i = 1; i < fringe.size(); i++){
    		if(dijkstra[fringe.get(i)] < minVal){
    			minIdx = i;
    			minVal = dijkstra[fringe.get(i)];
    		}
    	}
    	return minIdx;
    }
}
