package baodavi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
*/

public class ReconstructItinerary {
	
	public List<String> findItinerarySolution(String[][] tickets) {
		
	}
	
    public List<String> findItinerary(String[][] tickets) {
        Map<String, List<String>> ticketMap = new HashMap<>();
        for(int i = 0; i < tickets.length; i++){
        	if(ticketMap.containsKey(tickets[i][0])){
        		ticketMap.get(tickets[i][0]).add(tickets[i][1]);
        	}else{
        		List<String> destinations = new ArrayList<>();
        		destinations.add(tickets[i][1]);
        		ticketMap.put(tickets[i][0], destinations);
        	}
        }
        
        List<String> res = new ArrayList<>();
        String currLag = "JFK";
        res.add(currLag);
        while(true){
        	if(ticketMap.containsKey(currLag)){
        		List<String> destinations = ticketMap.get(currLag);
        		Collections.sort(destinations);
        		int ind = 0;
        		while(res.contains(currLag) && ind < destinations.size()){
        			currLag = destinations.get(ind);
        			ind++;
        		}
        		if(ind >= destinations.size()){
        			break;
        		}
        		res.add(currLag);
        	}else{
        		break;
        	}
        }
        return res;
    }
}
