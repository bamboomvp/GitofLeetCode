package baodavi;

import java.util.Arrays;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
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
				res[indRes++] = nums1[p1++];
				p2++;
			}
		}
		return Arrays.copyOf(res, indRes);
    }
}
