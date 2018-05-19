package baodavi;

public class BeautifulArrangement {
    public int countArrangement(int N) {
        boolean[] visited = new boolean[N];
        return countArrangementHelper(N, 0, visited);
    }
    
    private int countArrangementHelper(int N, int pos, boolean[] visited){
    	if(pos == N)	return 1;
    	int cnt = 0;
    	for(int i = 1; i <= N; i++){
    		if(visited[i - 1])	continue;
    		if(i % (pos + 1) == 0 || (pos + 1) % i == 0){
    			visited[i - 1] = true;
    			cnt += countArrangementHelper(N, pos + 1, visited);
    			visited[i - 1] = false;
    		}
    	}
    	return cnt;
    }
}
