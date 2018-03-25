package baodavi;

import java.util.Arrays;

public class PerfectSquares {
    public int numSquares(int n) {
//    	���һ����x���Ա�ʾΪһ��������a����һ��ƽ����b��b��
//    	Ҳ����x=a+b��b����ô����������x���ٵ�ƽ����������
//    	���������a���ٵ�ƽ������������1����Ϊb*b�Ѿ���ƽ�����ˣ���
    	int[] dp = new int[n + 1];
    	Arrays.fill(dp, Integer.MAX_VALUE);
    	dp[0] = 0;
    	for(int i = 1; i * i <= n; i++){
    		dp[i * i] = 1;
    	}
    	for(int a = 0; a <= n; a++){
    		for(int b = 1; a + b * b <= n; b++){
    			dp[a  + b * b] = Math.min(dp[a] + 1, dp[a  + b * b]);
    		}
    	}
    	return dp[n];
    }
}
