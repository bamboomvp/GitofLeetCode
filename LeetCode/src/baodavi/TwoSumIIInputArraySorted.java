package baodavi;

public class TwoSumIIInputArraySorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int ptr1 = 0, ptr2 = numbers.length - 1;
        while(ptr1 < ptr2){
        	if(numbers[ptr1] + numbers[ptr2] == target){
        		res[0] = ptr1 + 1;
        		res[1] = ptr2 + 1;
        		break;
        	}else if(numbers[ptr1] + numbers[ptr2] > target){
        		ptr2--;
        	}else{
        		ptr1++;
        	}
        }
        return res;
    }
}