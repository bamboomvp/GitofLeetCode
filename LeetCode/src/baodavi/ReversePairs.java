package baodavi;

public class ReversePairs {
    public int reversePairs(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1){
        	return 0;
        }else{
        	int cnt = 0;
        	for(int j = 1; j < nums.length; j++){
        		for(int i = 0; i < j; i++){
        			// ++
        			if(nums[i] >= 0 && nums[j] >= 0){
        				int tmp1 = nums[i] - nums[j];
        				if(tmp1 >= 0){
        					int tmp2 = tmp1 - nums[j];
        					if(tmp2 > 0){
        						cnt++;
        					}
        				}
        			}
        			// --
        			else if(nums[i] < 0 && nums[j] < 0){
        				int tmp1 = nums[i] - nums[j];
        				if(tmp1 >= 0){
        					cnt++;
        				}else{
        					int tmp2 = tmp1 - nums[j];
        					if( tmp2 > 0){
        						cnt++;
        					}
        				}
        			}
        			// +-
        			else if(nums[i] >= 0 && nums[j] < 0){
        				cnt++;
        			}
        			// -+
        			else if(nums[i] < 0 && nums[j] >= 0){
        				;
        			}
        		}
        	}
        	return cnt;
        }
    }
    
    public int reversePairsDAndC(int[] nums) {
    	if(nums == null | nums.length == 0)
    		return 0;
    	else if(nums.length == 1)
    		return 0;
    	else
    		return reversePairsDAndCSub(nums, 0, nums.length - 1);
    }
    
    private int reversePairsDAndCSub(int[] nums, int left, int right){
    	if(left >= right)
    		return 0;
    	if(left + 1 == right){
    		int tmpRes;
    		if(nums[left] > 2L * nums[right]){
    			tmpRes = 1;
    		}else{
    			tmpRes = 0;
    		}
    		if(nums[left] > nums[right]){
    			int tmp = nums[left];
    			nums[left] = nums[right];
    			nums[right] = tmp;
    		}
    		return tmpRes;
    	}
    	
    	int mid = left + (right - left) / 2;
    	int res = reversePairsDAndCSub(nums, left, mid) + reversePairsDAndCSub(nums, mid + 1, right);
    	
    	int ptr1 = left;
    	int ptr2 = mid + 1;
    	while(ptr1 <= mid && ptr2 <= right){
    		if(nums[ptr1] > 2L * nums[ptr2]){
    			res += (mid - ptr1) + 1;
    			ptr2++;
    		}else{
    			ptr1++;
    		}
    	}
//    	if(ptr1 <= mid){
//    		res += (mid - ptr1) * (right - mid);
//    	}
    	
    	// merge two sorted arrays before yield up
    	int ptr3 = left;
    	int ptr4 = mid + 1;
    	int [] merge = new int[right - left + 1];
    	int mptr = 0;
    	while(ptr3 <= mid && ptr4 <= right){
    		if(nums[ptr3] < nums[ptr4]){
    			merge[mptr++] = nums[ptr3++];
    		}else{
    			merge[mptr++] = nums[ptr4++];
    		}
    	}
    	while(ptr3 <= mid)	merge[mptr++] = nums[ptr3++];
    	while(ptr4 <= right)	merge[mptr++] = nums[ptr4++];
    	
    	System.arraycopy(merge, 0, nums, left, merge.length);
    	
    	return res;
    }
    
    class Node {
    	Node left, right;
    	int val;
    	int cntGE;
    	Node(int val){
    		this.val = val;
    		this.cntGE = 1;
    		this.left = null;
    		this.right = null;
    	}
    }
    
    int searchTree(Node root, long targetVal){
    	if(root == null)	return 0;
    	else if(root.val == targetVal)	return root.cntGE;
    	else if(root.val < targetVal){
    		return searchTree(root.right, targetVal);
    	}else{
    		return root.cntGE + searchTree(root.left, targetVal);
    	}
    }
    
    Node insertTree(Node root, int val){
    	if(root == null){
    		return new Node(val);
    	}else if(root.val == val){
    		root.cntGE++;
    	}else if(root.val < val){
    		root.cntGE++;
    		root.right = insertTree(root.right, val);
    	}else{
    		root.left = insertTree(root.left, val);
    	}
    	return root;
    }
    
    public int reversePairsTree(int[] nums) {
    	Node root = null;
    	int globalCnt = 0;
    	for(int i = 0; i < nums.length; i++){
    		globalCnt += searchTree(root, (2L * nums[i]) + 1);
    		root = insertTree(root, nums[i]);
    	}
    	return globalCnt;
    }
    
    public static void main(String[] args){
    	ReversePairs instance = new ReversePairs();
    	instance.reversePairsDAndC(new int[]{1, 3, 2, 3, 1});
    }
}
