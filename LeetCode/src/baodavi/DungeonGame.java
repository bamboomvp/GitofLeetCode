package baodavi;
public class DungeonGame {
	public class HPContainer {
		int HP;

		HPContainer(int initVal) {
			this.HP = initVal;
		}
	}

	private void calculateMinimumHPHelper(int[][] dungeon, int x, int y,
			int hp, HPContainer currMax, HPContainer max) {
		if (hp + dungeon[x][y] <= 0) {
			currMax.HP += Math.abs(hp + dungeon[x][y]) + 1;
			hp = 1;
		} else {
			hp = hp + dungeon[x][y];
		}

		if(currMax.HP > max.HP){
			return;
		}
		
		if (x == dungeon.length - 1 && y == dungeon[0].length - 1) {
			if (currMax.HP > max.HP) {
				max.HP = currMax.HP;
			}
			return;
		}

		if (x != dungeon.length - 1) {
			calculateMinimumHPHelper(dungeon, x + 1, y, hp, currMax, max);
		}

		if (y != dungeon[0].length - 1) {
			calculateMinimumHPHelper(dungeon, x, y + 1, hp, currMax, max);
		}
	}

	public int calculateMinimumHP(int[][] dungeon) {
		HPContainer min = new HPContainer(Integer.MAX_VALUE);
		calculateMinimumHPHelper(dungeon, 0, 0, 1, new HPContainer(1),
				new HPContainer(Integer.MAX_VALUE));
		return min.HP;
	}
	
	public int calculateMinimumHPOfDPAfter2Years(int[][] dungeon) {
		if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0){
			return -1;
		}
		
		int[][] health = new int[dungeon.length][dungeon[0].length];
		// traverse, iterate through the array from bottom-right back to top-left
		for(int i = health.length - 1; i >= 0; i--){
			for(int j = health[0].length - 1; j >= 0; j--){
				// condition1: it has to be at least to endure the damage at current cell
				int val1 = Math.max(1, 1 - dungeon[i][j]);
				// condition2/3: it can at least to carry us to (a) the right, (b) the bottom, 
				// whichever exists and costs less
				int val2 = 0, val3 = 0;
				boolean flag2, flag3;
				flag2 = flag3 = false;
				if(i + 1 <= health.length - 1){
					val2 = health[i + 1][j] - dungeon[i][j];
					flag2 = true;
				}
				if(j + 1 <= health[0].length - 1){
					val3 = health[i][j + 1] - dungeon[i][j];
					flag3 = true;
				}
				
				if(flag2 && flag3){
					health[i][j] = Math.max(val1, Math.min(val2, val3));
				}else if(flag2){
					health[i][j] = Math.max(val1, val2);
				}else if(flag3){
					health[i][j] = Math.max(val1, val3);
				}else{
					health[i][j] = val1;
				}
			}
		}
		
		return health[0][0];
	}
	
}
