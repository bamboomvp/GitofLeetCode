package baodavi;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
    	int[][] distSqrArr = new int[points.length][points.length];
    	for(int first = 0; first < points.length - 1; first++){
    		for(int second = first + 1; second < points.length; second++){
    			int distSqr = (points[first][0] - points[second][0]) *  (points[first][0] - points[second][0]) + 
    					(points[first][1] - points[second][1]) *  (points[first][1] - points[second][1]);
    			distSqrArr[first][second] = distSqrArr[second][first] = distSqr;
    		}
    	}
    	int res = 0;
    	for(int i = 0; i < points.length; i++){
    		for(int j = 0; j < points.length; j++){
    			if(j == i)	continue;
    			for(int k = j + 1; k < points.length; k++){
    				if(k == i)	continue;
    				if(distSqrArr[i][j] == distSqrArr[i][k])
    					res += 2;
    			}
    		}
    	}
    	return res;
    }
    
    public int numberOfBoomerangsUPDATE(int[][] points) {
    	int res = 0;
    	// key - distance between 2 points
    	// val - occurrences of such distance 
    	Map<Integer, Integer> map = new HashMap<>();
    	// consider all points to be the i
    	for(int i = 0; i < points.length; i++){
    		map.clear();
    		// get the distances of all points to the i
    		for(int x = 0; x < points.length; x++){
    			int a = points[i][0] - points[x][0];
    			int b = points[i][1] - points[x][1];
    			int distSqr = a * a + b * b;
    			if(!map.containsKey(distSqr)){
    				map.put(distSqr, 0);
    			}
    			map.put(distSqr, map.get(distSqr) + 1);
    		}
    		for(int nums : map.values()){
    			res += nums * (nums - 1);
    		}
    	}
    	return res;
    }
}
