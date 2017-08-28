package baodavi;

public class TeemoAttacking {
	//	不闲扯了，其实这道题蛮简单的，感觉不能算一道medium的题，就直接使用贪心算法，
	//	比较相邻两个时间点的时间差，如果小于duration，就加上这个差，如果大于或等于，就加上duration即可
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
