package baodavi;
import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}

		@Override
		public String toString() {
			return "[" + start + "," + end + "]";
		}
	}

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

		// special case
		if (intervals.isEmpty()) {
			intervals.add(newInterval);
			return intervals;
		}

		// insert phase
		int low = 0;
		int high = intervals.size() - 1;
		int index = -1;
		int mid = -1;
		while (low <= high) {
			mid = (low + high) / 2;
			if (intervals.get(mid).start < newInterval.start) {
				low = mid + 1;
				index = mid + 1;
			} else if (intervals.get(mid).start > newInterval.start) {
				high = mid - 1;
				index = mid;
			} else {
				index = mid;
				break;
			}
		}

		intervals.add(index, newInterval);

		// merge phase
		int start = intervals.get(index).start;
		int end = intervals.get(index).end;
		int insertInd = index;
		List<Interval> toRemove = new ArrayList<Interval>();
		toRemove.add(intervals.get(index));
		if (index - 1 >= 0 && intervals.get(index - 1).end >= newInterval.start) {
			toRemove.add(intervals.get(index - 1));
			start = intervals.get(index - 1).start;
			end = Math.max(intervals.get(index).end,
					intervals.get(index - 1).end);
			insertInd--;
		}

		index++;
		while (index < intervals.size() && intervals.get(index).start <= end) {
			toRemove.add(intervals.get(index));
			end = Math.max(intervals.get(index).end, end);
			index++;
		}

		intervals.removeAll(toRemove);
		intervals.add(insertInd, new Interval(start, end));

		return intervals;
	}

	public static void main(String[] args) {
		InsertInterval ins = new InsertInterval();
		List<Interval> l = new ArrayList<Interval>();
		l.add(ins.new Interval(1, 5));
		l.add(ins.new Interval(6, 8));
		ins.insert(l, ins.new Interval(5, 6));
	}
}
