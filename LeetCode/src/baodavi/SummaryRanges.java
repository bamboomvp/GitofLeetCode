package baodavi;
import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
        	return res;
        }
        int startIdx = 0;
        int currIdx = 1;
        while(currIdx < nums.length){
        	if(nums[currIdx] - nums[currIdx - 1] == 1){
        		currIdx++;
        	}else{
        		String str = (startIdx != currIdx - 1) ? nums[startIdx] + "->" + nums[currIdx - 1] : "" + nums[startIdx];
        		res.add(str);
        		startIdx = currIdx;
        		currIdx++;
        	}
        }
        String str2 = (startIdx !=  nums.length - 1) ? nums[startIdx] + "->" + nums[ nums.length - 1] : "" + nums[startIdx];
        res.add(str2);
        return res;
    }
}
