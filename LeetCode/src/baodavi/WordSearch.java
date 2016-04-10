package baodavi;


public class WordSearch {
	
    public boolean exist(char[][] board, String word) {
    	if(board == null || board.length == 0){
    		return false;
    	}
    	
    	if(board[0] == null || board[0].length == 0){
    		return false;
    	}
    	
    	if(word == null || word.length() == 0){
    		return false;
    	}
    	
    	int rowsNum = board.length;
    	int colsNum = board[0].length;
    	
    	for(int i = 0; i < board.length; i++){
    		for(int j = 0; j < board[0].length; j++){
    			boolean[][] visited = new boolean[rowsNum][colsNum];
				if(board[i][j] == word.charAt(0)){
					if(existHelper(i, j, 0, board, word, visited)){
						return true;
					}					
				}
    		}
    	}
    	
    	return false;
    }
    
    private boolean existHelper(int currX, int currY, int currPos, char[][] board, String word, boolean[][] visited){
    	if(currPos == word.length() - 1){
    		return true;
    	}else{
    		visited[currX][currY] = true;
    		if(currX - 1 >= 0 && !visited[currX - 1][currY] && board[currX - 1][currY] == word.charAt(currPos + 1)){
    			boolean localRes = existHelper(currX - 1, currY, currPos + 1, board, word, visited);
    			if(localRes)
    				return true;
    		}
    		
    		if(currX + 1 < board.length && !visited[currX + 1][currY] && board[currX + 1][currY] == word.charAt(currPos + 1)){
    			boolean localRes = existHelper(currX + 1, currY, currPos + 1, board, word, visited);
    			if(localRes)
    				return true;
    		}

    		if(currY - 1 >= 0 && !visited[currX][currY - 1] && board[currX][currY - 1] == word.charAt(currPos + 1)){
    			boolean localRes = existHelper(currX, currY - 1, currPos + 1, board, word, visited);
    			if(localRes)
    				return true;
    		}

    		if(currY + 1 < board[0].length && !visited[currX][currY + 1] && board[currX][currY + 1] == word.charAt(currPos + 1)){
    			boolean localRes = existHelper(currX, currY + 1, currPos + 1, board, word, visited);
    			if(localRes)
    				return true;
    		}
    		visited[currX][currY] = false;
    		return false;
    	}
    }
    
    
    public boolean existEnhanced(char[][] board, String word) {
          int m = board.length;  
          int n = board[0].length;  
          boolean[][] visited = new boolean[m][n];  
          for (int i = 0; i < m; i++) {  
              for (int j = 0; j < n; j++) {  
                  if (dfs(board, word, 0, i, j, visited))  
                      return true;  
              }  
         }  
         return false;  
     }
     
     private boolean dfs(char[][] board, String word, int index, int rowindex, int colindex, boolean[][] visited) {  
         if (index == word.length())  
             return true;  
         if (rowindex < 0 || colindex < 0 || rowindex >=board.length || colindex >= board[0].length)  
             return false;  
         if (visited[rowindex][colindex])  
             return false;  
         if (board[rowindex][colindex] != word.charAt(index))  
             return false;  
         visited[rowindex][colindex] = true;  
         boolean res = dfs(board, word, index + 1, rowindex - 1, colindex,  
                 visited)  
                 || dfs(board, word, index + 1, rowindex + 1, colindex, visited)  
                 || dfs(board, word, index + 1, rowindex, colindex + 1, visited)  
                 || dfs(board, word, index + 1, rowindex, colindex - 1, visited);  
         visited[rowindex][colindex] = false;  
         return res;  
     }
}
