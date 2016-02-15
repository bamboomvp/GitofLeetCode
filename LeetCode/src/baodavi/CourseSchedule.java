package baodavi;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
    	// count number of prerequisites for each course
    	int[] numOfPres = new int[numCourses];
    	for(int i = 0; i < prerequisites.length; i++){
    		numOfPres[prerequisites[i][0]]++;
    	}
    	
    	// store courses that have no prerequisites into the queue
    	Queue<Integer> q = new LinkedList<Integer>();
    	for(int j = 0; j < numCourses; j++){
    		if(numOfPres[j] == 0){
    			q.add(j);
    		}
    	}
    	
    	// number of courses that have no prerequisites
    	int numNoPre = q.size();
    	
    	// BFS
    	while(!q.isEmpty()){
    		Integer top = q.remove();
    		for(int k = 0; k <  prerequisites.length; k++){
    			if(prerequisites[k][1] == top){
    				numOfPres[prerequisites[k][0]]--;
    				if(numOfPres[prerequisites[k][0]] == 0){
    					q.add(prerequisites[k][0]);
    					numNoPre++;
    				}
    			}
    		}
    	}
    	
    	return numNoPre == numCourses;
    }
}
