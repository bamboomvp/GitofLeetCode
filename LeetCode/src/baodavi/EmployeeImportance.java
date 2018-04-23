package baodavi;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class EmployeeImportance {
	class Employee {
	    // It's the unique id of each node;
	    // unique id of this employee
	    public int id;
	    // the importance value of this employee
	    public int importance;
	    // the id of direct subordinates
	    public List<Integer> subordinates;
	};
	
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee employee : employees){
        	map.put(employee.id, employee);
        }
        Employee e = map.get(id);
        if(e == null)	return 0;
        int score = 0;
        Queue<Employee> queue = new LinkedList<Employee>();
        queue.add(e);
        while(!queue.isEmpty()){
        	Employee currE = queue.poll();
        	score += currE.importance;
        	for(Integer subID : currE.subordinates){
        		queue.add(map.get(subID));
        	}
        }
        return score;
    }	
}
