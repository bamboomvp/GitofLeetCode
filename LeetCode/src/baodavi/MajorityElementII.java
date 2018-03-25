package baodavi;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        int cnt1 = 0;
        int cnt2 = 0;
        int num1, num2;
        num1 = num2 = -1; // whatever number...
        for(int i = 0; i < nums.length; i++){
        	if(nums[i] == num1){
        		cnt1++;
        	}else if(nums[i] == num2){
        		cnt2++;
        	}else if(cnt1 == 0){
        		num1 = nums[i];
        		cnt1++;
        	}else if(cnt2 == 0){
        		num2 = nums[i];
        		cnt2++;
        	}else{
        		cnt1--;
        		cnt2--;
        	}
        }
        
        cnt1 = cnt2 = 0; // reset to validate
        for(int j = 0; j < nums.length; j++){
        	if(nums[j] == num1)	cnt1++;
        	else if(nums[j] == num2)	cnt2++;
        }
        List<Integer> res = new ArrayList<>();
        if(cnt1 >= nums.length / 3 + 1)	res.add(num1);
        if(cnt2 >= nums.length / 3 + 1)	res.add(num2);
        return res;
    }
}
