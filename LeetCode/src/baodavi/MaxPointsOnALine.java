package baodavi;
public class MaxPointsOnALine {

	class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

	private boolean onTheLine(Point k, Point start, Point end) {
		return (start.y - end.y) * (start.x - k.x) == (start.y - k.y)
				* (start.x - end.x);
	}

	// special case!!! be careful!!!
	private boolean allSamePoints(Point[] points) {
		for (int x = 1; x < points.length; x++) {
			if (!(points[0].x == points[x].x && points[0].y == points[x].y))
				return false;
		}
		return true;
	}

	public int maxPoints(Point[] points) {

		if (points == null || points.length == 0) {
			return 0;
		}

		if (points.length == 1) {
			return 1;
		}

		if (allSamePoints(points)) {
			return points.length;
		}

		int globalMax = 2;

		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				if (points[i].x == points[j].x && points[i].y == points[j].y) {
					continue; // special case!!! be careful!!!
				}
				int localMax = 2;
				for (int k = 0; k < points.length; k++) {
					if (k != i && k != j
							&& onTheLine(points[k], points[i], points[j]))
						localMax++;
				}
				if (localMax > globalMax)
					globalMax = localMax;
			}
		}

		return globalMax;
	}
}
