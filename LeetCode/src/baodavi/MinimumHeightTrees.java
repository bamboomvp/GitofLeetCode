package baodavi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.

Format
The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example 1:

Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

        0
        |
        1
       / \
      2   3
return [1]

Example 2:

Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
      \ | /
        3
        |
        4
        |
        5
return [3, 4]
*/

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> res = new HashMap<>();
        for(int i = 0; i < n; i++){
        	res.put(i, new ArrayList<Integer>());
        }
        
        for(int j = 0; j < edges.length; j++){
        	int v1 = edges[j][0];
        	int v2 = edges[j][1];
        	res.get(v1).add(v2);
        	res.get(v2).add(v1);
        }
        
        while(res.size() > 2){
        	List<List<Integer>> tmp = new ArrayList<>();
        	for(Iterator<Map.Entry<Integer, List<Integer>>> it = res.entrySet().iterator(); it.hasNext(); ){
        		Map.Entry<Integer, List<Integer>> entry = it.next();
        		if(entry.getValue().size() == 1){
        			int v1 = entry.getValue().get(0);
        			int v2 = entry.getKey();
        			tmp.add(Arrays.asList(v1, v2));
        			//res.get(v1).remove(Integer.valueOf(v2));
        			it.remove();
        		}
        	}
        	
        	for(List<Integer> hehe : tmp){
        		res.get(hehe.get(0)).remove(Integer.valueOf(hehe.get(1)));
        	}
        }
        
        return new ArrayList<Integer>(res.keySet());
    }
}
