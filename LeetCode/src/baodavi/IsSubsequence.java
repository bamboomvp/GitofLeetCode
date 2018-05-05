package baodavi;

public class IsSubsequence {
	
	// ���ǿ���������ָ��ֱ�ָ���ַ���s��t��Ȼ������ַ���ȣ���i��j����1����ֻ֮��j����1�����i�Ƿ����s�ĳ��ȣ�����˵��s�Ѿ��������ˣ������ַ�������t�г��ֹ�
	
    public boolean isSubsequence(String s, String t) {
    	// first validation
        int[] freqCnt = new int[26];
        for(char currChar : t.toCharArray()){
        	freqCnt[currChar - 'a'] += 1;
        }
        int[] compareFreqCnt = new int[26];
        for(char currChar : s.toCharArray()){
        	compareFreqCnt[currChar - 'a'] += 1;
        }
        for(int k = 0; k < 26; k++){
        	if(freqCnt[k] - compareFreqCnt[k] < 0)
        		return false;
        }
        
        int ind = 0;
        for(char currChar : s.toCharArray()){
        	while(ind < t.length() && t.charAt(ind) != currChar){
        		ind++;
        	}
        	if(ind >= t.length())		return false;
        	else							ind++;
        }
        return true;
    }
}
