package baodavi;

public class FindPivotIndex {
	
//	�����������ܺͣ�Ȼ��ά��һ����ǰ����֮��curSum��
//	Ȼ����ڱ�������λ�ã����ܺͼ�ȥ��ǰ���֣����õ��Ľ���Ƿ���curSum��������
//	�ǵĻ�����ô��ǰλ�þ�������㣬���ؼ��ɣ�����ͽ���ǰ���ּӵ�curSum�м�������������������û���أ�˵��û������㣬����-1����
	public int pivotIndexUpdate(int[] nums) {
		int totalSum = 0;
		for(int i = 0; i < nums.length; i++)
			totalSum += nums[i];
		int currSum = 0;
		for(int j = 0; j < nums.length; j++){
			if(totalSum - nums[j] == 2 * currSum)		return j;
			currSum += nums[j];
		}
		return -1;
	}
	
    public int pivotIndex(int[] nums) {
        if(nums == null || nums.length == 0)	return -1;
        else if(nums.length == 1)					return 0;
        
        int[] sumFromLeft = new int[nums.length];
        int[] sumFromRight = new int[nums.length];
        int runningSum = 0;
        for(int j = nums.length - 1; j >= 0; j--){
        	runningSum += nums[j];
        	sumFromRight[j] = runningSum;
        }
        runningSum = 0;
        for(int i = 0; i < nums.length; i++){
        	runningSum += nums[i];
        	sumFromLeft[i] = runningSum;
        	if(i == 0){
        		if(sumFromRight[i + 1] == 0)	return i;
        	}else if(i == nums.length - 1){
        		if(sumFromLeft[i - 1] == 0)		return i;
        	}else{
        		if(sumFromLeft[i - 1] == sumFromRight[i + 1]) return i;
        	}
        }
        return -1;
    }
}
