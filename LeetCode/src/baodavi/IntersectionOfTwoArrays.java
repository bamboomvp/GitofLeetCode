package baodavi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoArrays {
	public int[] intersectionTwoPointers(int[] nums1, int[] nums2) {
		if(nums1 == null || nums2 == null){
			return new int[0];
		}
		int[] res = new int[(nums1.length < nums2.length) ? nums1.length : nums2.length];
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int p1 = 0, p2 = 0, indRes = 0;
		while(p1 < nums1.length && p2 < nums2.length){
			if(nums1[p1] < nums2[p2])	p1++;
			else if(nums1[p1] > nums2[p2])	p2++;
			else{
				if(indRes == 0 || res[indRes - 1] != nums1[p1]){
					res[indRes++] = nums1[p1];
				}
				p1++;
				p2++;
			}
		}
		return Arrays.copyOf(res, indRes);
	}
	
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
        	return new int[0];
        }
        List<Integer> resList = new ArrayList<>();
        int[] numsLong = (nums1.length < nums2.length) ? nums2 : nums1;
        int[] numsShort = (nums1 == numsLong) ? nums2 : nums1;
        Set<Integer> set = new HashSet<>();
        for(int num : numsLong){
        	set.add(num);
        }
        Arrays.sort(numsShort);
        for(int i = 0; i < numsShort.length; i++){
        	if(i != 0 && numsShort[i] == numsShort[i - 1])	continue;
        	if(set.contains(numsShort[i])){
        		resList.add(numsShort[i]);
        	}
        }
        int[] res = new int[resList.size()];
        for(int i = 0; i < resList.size(); i++){
        	res[i] = resList.get(i);
        }
        return res;
    }
}
