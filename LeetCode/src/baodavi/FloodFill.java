package baodavi;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    	if(newColor != image[sr][sc]){
    		floodFillHelper(image, sr, sc, newColor);
    	}
    	return image;
    }
    
    private void floodFillHelper(int[][] image, int sr, int sc, int newColor){
    	int oldColor = image[sr][sc];
    	image[sr][sc] = newColor;
    	if(sr - 1 >= 0 && image[sr - 1][sc] == oldColor){
    		floodFillHelper(image, sr - 1, sc, newColor);
    	}
    	if(sr + 1 < image.length && image[sr + 1][sc] == oldColor){
    		floodFillHelper(image, sr + 1, sc, newColor);
    	}
    	if(sc - 1 >= 0 && image[sr][sc - 1] == oldColor){
    		floodFillHelper(image, sr, sc - 1, newColor);
    	}
    	if(sc + 1 < image[0].length && image[sr][sc + 1] == oldColor){
    		floodFillHelper(image, sr, sc + 1, newColor);
    	}
    }
}
