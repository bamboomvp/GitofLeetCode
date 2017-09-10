package baodavi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CloneGraph {
	class UndirectedGraphNode {
		     int label;
		     List<UndirectedGraphNode> neighbors;
		     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	};
	
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)	return null;
        
        Map<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
        Set<UndirectedGraphNode> visited = new HashSet<>();
        Queue<UndirectedGraphNode> bfs = new LinkedList<>();
        for(int i = 0; i < 2; i++){
	        bfs.offer(node);
	        while(!bfs.isEmpty()){
	        	UndirectedGraphNode curr = bfs.poll();
	        	if(i == 0){
	        		UndirectedGraphNode newCurr = new UndirectedGraphNode(curr.label);
	        		mapping.put(curr, newCurr);
		        	List<UndirectedGraphNode> fringe = curr.neighbors;
		        	for(UndirectedGraphNode candidate : fringe){
		        		if(!mapping.keySet().contains(candidate)){
		        			mapping.put(candidate, null); // special case, de-duplicate
		        			bfs.offer(candidate);
		        		}
		        	}
	        	}else{
	        		visited.add(curr);
	        		for(UndirectedGraphNode neighbor : curr.neighbors){
	        			mapping.get(curr).neighbors.add(mapping.get(neighbor));
	        			if(!visited.contains(neighbor)){
	        				visited.add(neighbor); // special case, de-duplicate
	        				bfs.offer(neighbor);
	        			}
	        		}
	        	}
	        }
        }
        return mapping.get(node);
    }
}
