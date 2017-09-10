package baodavi;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleIAndII {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows <= 0)	return res;
        else{
        	for(int i = 1; i <= numRows; i++){
        		List<Integer> subRes = new ArrayList<>();
        		for(int j = 0; j < i; j++){
        			if(j == 0 || j == i - 1)	subRes.add(1);
        			else	subRes.add(res.get(i - 2).get(j - 1) + res.get(i - 2).get(j));
        		}
        		res.add(subRes);
        	}
        }
        return res;
    }
    
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if(rowIndex < 0)	return res;
        else{
        	int[] DP = new int[rowIndex + 1];
        	for(int i = 0; i < DP.length; i++){
        		for(int j = i; j >= 0; j--){
        			if(j == i || j == 0)	DP[j] = 1;
        			else						DP[j] = DP[j] + DP[j - 1];
        		}
        	}
        	for(int k = 0; k < DP.length; k++){
        		res.add(DP[k]);
        	}
        	return res;
        }
    }
}
