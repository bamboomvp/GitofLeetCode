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
}
