package baodavi;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0){
        	return res;
        }
        int width = grid.length;
        int length = grid[0].length;
        for(int i = 0; i < width; i++){
        	for(int j = 0; j < length; j++){
        		if(grid[i][j] == 0)	continue;
        		if(i == 0 || grid[i - 1][j] == 0)	res++;
        		if(i == width - 1 || grid[i + 1][j] == 0)	res++;
        		if(j == 0 || grid[i][j - 1] == 0)	res++;
        		if(j == length - 1 || grid[i][j + 1] == 0)	res++;
        	}
        }
        return res;
    }
}
