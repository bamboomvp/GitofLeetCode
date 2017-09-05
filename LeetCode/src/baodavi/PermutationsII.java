package baodavi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> finalRes = new ArrayList<>();
		if(nums == null || nums.length == 0)	return finalRes;
		else{
			List<Integer> pickedIndice = new ArrayList<>();
			Set<String> bookkeeping = new HashSet<>();
			StringBuilder sb = new StringBuilder();
			permuteUniqueHelper(nums, pickedIndice, bookkeeping, sb, finalRes);
			return finalRes;
		}
	}
	
	private void permuteUniqueHelper(int[] nums, List<Integer> pickedIndice, Set<String> bookkeeping, StringBuilder sb, List<List<Integer>> finalRes){
		if(pickedIndice.size() == nums.length){
			List<Integer> newRes = new ArrayList<>();
			sb.setLength(0);
			for(int index : pickedIndice){
				newRes.add(nums[index]);
				sb.append(nums[index]);
			}
			String newKeep = sb.toString();
			if(!bookkeeping.contains(newKeep)){
				finalRes.add(newRes);
				bookkeeping.add(newKeep);
			}
			return;
		}
		
		for(int i = 0; i < nums.length; i++){
			if(pickedIndice.contains(i)){
				continue;
			}else{
				pickedIndice.add(i);
				permuteUniqueHelper(nums, pickedIndice, bookkeeping, sb, finalRes);
				pickedIndice.remove(pickedIndice.size() - 1);
			}
		}
		
		return;
	}
	
	// 1. Use an extra boolean array "boolean[] used" to indicate whether the value is added to list.
	// 2. Sort the array "int[] nums" to make sure we can skip the same value.
	// 3. When a number has the same value with its previous, we can use this number only if his previous is used.
	public List<List<Integer>> permuteUniqueReferI(int[] nums) {
		List<List<Integer>> finalRes = new ArrayList<>();
		if(nums == null || nums.length == 0)	return finalRes;
		boolean[] used = new boolean[nums.length];
		List<Integer> list = new ArrayList<>();
		Arrays.sort(nums);
		dfs(nums, used, list, finalRes);
		return finalRes;
	}
	
	private void dfs(int nums[], boolean[] used, List<Integer> list, List<List<Integer>> res){
		if(list.size() == nums.length){
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for(int i = 0; i < nums.length; i++){
			if(used[i])	continue;
			if(i > 0 && nums[i - 1] == nums[i] && !used[i - 1])	continue;
			used[i] = true;
			list.add(nums[i]);
			dfs(nums, used, list, res);
			list.remove(list.size() - 1);
			used[i] = false;
		}
	}
	
	/*
	 还有一种比较简便的方法，在Permutations的基础上稍加修改，我们用set来保存结果，
	 利用其不会有重复项的特点，然后我们再递归函数中的swap的地方，判断如果i和start不相同，
	 但是nums[i]和nums[start]相同的情况下跳过，继续下一个循环
	 */
	public List<List<Integer>> permuteUniqueReferII(int[] nums) {
		List<List<Integer>> finalRes = new ArrayList<>();
		if(nums == null || nums.length == 0)	return finalRes;
		permuteUniqueReferIIHelper(nums, 0, finalRes);
		return finalRes;
	}
	
	private void permuteUniqueReferIIHelper(int[] nums, int start, List<List<Integer>> res){
		if(start == nums.length){
			List<Integer> resElem = new ArrayList<>();
			for(int i = 0; i < nums.length; i++)
				resElem.add(nums[i]);
			res.add(resElem);
		}
		
		for(int j = start; j < nums.length; j++){
			if(noSwapCheck(start, j, nums)) continue;
			swap(start, j, nums);
			permuteUniqueReferIIHelper(nums, start + 1, res);
			swap(start, j, nums);
		}
	}
	
	private void swap(int i1, int i2, int[] nums){
		int tmp = nums[i1];
		nums[i1] = nums[i2];
		nums[i2] = tmp;
	}
	
	private boolean noSwapCheck(int start, int curr, int[] nums){
		if(curr != start && nums[curr] == nums[start])
			return true;
		else{
			for(int i = start; i < curr; i++){
				if(nums[i] == nums[curr])	
					return true;
			}
			return false;
		}
	}
}
