package baodavi;

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
    	if(num == 1)	return true;
    	int low = 1;
    	int high = num;
        while(low <= high){
        	int mid = low + (high - low) / 2;
        	int other = num / mid;
        	if(other == mid)	return true;
        	else{
        		if(other > mid){
        			low = mid + 1;
        		}else{
        			high = mid - 1;
        		}
        	}
        }
        return false;
    }
    
    // ���ֲ��ҷ�������Ҫ���ҵ���Ϊmid*mid
    public boolean isPerfectSquareS1(int num) {
    	long left = 0, right = num;
    	while(left <= right){
    		long mid = left + (right - left) / 2;
    		long t = mid * mid;
    		if(t == num)	return true;
    		else if(t < num)	left = mid + 1;
    		else	right = mid - 1;
    	}
    	return false;
    }
    
    // ��1������sqrt(num)������û��ƽ�����õ���num����
    // TLE...
    public boolean isPerfectSquareS2(int num) {
    	for(int i = 1; i * i <= num; i++){
    		if(i * i == num) return true;
    	}
    	return false;
    }
    
    // ��2��С��ΧȻ�����
    public boolean isPerfectSquareS3(int num) {
    	if(num == 1)	return true;
    	int x = num / 2;
    	long t = x * x;
    	while(t > num){
    		x /= 2;
    		t = x * x;
    	}
    	for(int i = x; i <= 2 * x; i++){
    		if(i * i == num)	return true;
    	}
    	return false;
    }
    
    // ����ѧ�ⷨ: ��ȫƽ������һϵ������֮��
    public boolean isPerfectSquareS4(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
}
