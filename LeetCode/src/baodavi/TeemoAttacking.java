package baodavi;

public class TeemoAttacking {
	//	���г��ˣ���ʵ��������򵥵ģ��о�������һ��medium���⣬��ֱ��ʹ��̰���㷨��
	//	�Ƚ���������ʱ����ʱ�����С��duration���ͼ�������������ڻ���ڣ��ͼ���duration����
    public int findPoisonedDuration(int[] timeSeries, int duration) {
    	int res = 0;
    	if(timeSeries.length == 0 || duration == 0)
    		return res;
    	else if(timeSeries.length == 1)
    		return duration;
    	else{
    		for(int i = 1; i < timeSeries.length; i++){
    			int diff = timeSeries[i] - timeSeries[i - 1];
    			res += (diff < duration) ? diff : duration;
    		}
    		return res + duration;
    	}
    }
}
