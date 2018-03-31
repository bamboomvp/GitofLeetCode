package baodavi;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
	// iteration all possibilities
	public List<String> readBinaryWatchS1(int num) {
		List<String> res = new ArrayList<>();
		for(int h = 0; h < 12; h++){
			for(int m = 0; m < 60; m++){
				int tmp = (h << 6) + m;
				int cnt = numOf1Bits(tmp);
				if(cnt == num){
					String time = "";
					time += h;
					time += m < 10 ? ":0" : ":";
					time += m;
					res.add(time);
				}
			}
		}
		return res;
	}
	
	private int numOf1Bits(int input){
		int cnt = 0;
		while(input > 0){
			cnt += input & 1;
			input >>= 1;
		}
		return cnt;
	}
	
	// 那么思路是，如果总共要取num个，
	// 我们在小时集合里取i个，算出和，
	// 然后在分钟集合里去num-i个求和，如果两个都符合题意，那么加入结果中即可
	
	// 其实就是反过来枚举
	public List<String> readBinaryWatchS2(int num) {
		List<String> res = new ArrayList<>();
		int[] hours = new int[]{8, 4, 2, 1};
		int[] minutes = new int[]{32, 16, 8, 4, 2, 1};
		for(int i = 0; i <= num && i <=4; i++){
			if(num - i > 6)	continue; // edge case
			List<Integer> hourCombo = generate(hours, i);
			List<Integer> minuteCombo = generate(minutes, num - i);
			for(int h : hourCombo){
				if(h > 11) continue;
				for(int m : minuteCombo){
					if(m > 59) continue;
					res.add("" + h + (m < 10 ? ":0" : ":") + m);
				}
			}
		}
		return res;
	}
	
	private List<Integer> generate(int[] nums, int pick){
		List<Integer> res = new ArrayList<>();
		generateHelper(nums, pick, 0, 0, res);
		return res;
	}
	
	private void generateHelper(int[] nums, int pick, int index, int val, List<Integer> res){
		if(pick == 0){
			res.add(val);
			return;
		}
		// pick the current
		generateHelper(nums, pick - 1, index + 1, val + nums[index], res);
		// skip the current, conditionally
		if(nums.length - index > pick){
			generateHelper(nums, pick, index + 1, val, res);
		}
	}
}
