package baodavi;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int islandCnt = 0;
        
        if(grid == null){
        	return 0;
        }else if(grid.length == 0){
        	return 0;
        }else if(grid[0].length == 0){
        	return 0;
        }
        
        // we iterate through each "land" and use it as the starting point to explore "island", 
        // marking the already checked "land" with "2",  and skipping all the "water" and "explored lands", aka, 0 and 2.
        for(int i = 0; i < grid.length; i++){
        	for(int j = 0; j < grid[i].length; j++){
        		if(grid[i][j] == '1'){
        			exploreCurrentLand(i, j, grid);
        			islandCnt++; // once we find a land, there is a island...
        		}
        	}
        }
        
        return islandCnt;
    }
    
    private void exploreCurrentLand(int i, int j, char[][] grid){
    	grid[i][j] = '2'; // mark explored land
    	
    	if(i - 1 >= 0 && grid[i - 1][j] == '1'){
    		exploreCurrentLand(i - 1, j, grid);
    	}
    	
    	if(i + 1 < grid.length && grid[i + 1][j] == '1'){
    		exploreCurrentLand(i + 1, j, grid);
    	}
    	
    	if(j - 1 >= 0 && grid[i][j - 1] == '1'){
    		exploreCurrentLand(i, j - 1, grid);
    	}
    	
    	if(j + 1 < grid[i].length && grid[i][j + 1] == '1'){
    		exploreCurrentLand(i, j + 1, grid);
    	}
    }
    
    public static void main(String[] args){
    }
}
