/*

Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
// public class Solution {
//     public List<Interval> merge(List<Interval> intervals) {
//         List<Interval> res = new ArrayList<Interval>();
//         for (Interval interval : intervals) {
//             insert(res,interval);
//         }
//         return res;
//     }

//     // reuse the code
//     public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
//         if (intervals == null || newInterval == null) {
//             return intervals;
//         }

//         if (intervals.size() == 0) {
//             intervals.add(newInterval);
//             return intervals;
//         }

//         ListIterator<Interval> it = intervals.listIterator();
//         while (it.hasNext()) {
//             Interval temp = it.next();
//             if (newInterval.end < temp.start) {
//                 it.previous();
//                 it.add(newInterval);
//                 return intervals;
//             } else {
//                 if (temp.end < newInterval.start) {
//                     continue;
//                 } else {
//                     newInterval.start = Math.min (temp.start, newInterval.start);
//                     newInterval.end = Math.max (temp.end, newInterval.end);
//                     it.remove();
//                 }
//             }
//         }
//         intervals.add(newInterval);
//         return intervals;

//     }
// }
public class Solution {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {  
		ArrayList<Interval> res = new ArrayList<Interval>();  
		if(intervals==null || intervals.size()==0)  
			return intervals;  
		Comparator<Interval> comp = new Comparator<Interval>()  
		{  
			@Override  
			public int compare(Interval i1, Interval i2)  
			{  
				if(i1.start==i2.start)  
					return i1.end-i2.end;  
				return i1.start-i2.start;  
			}  
		};  
		Collections.sort(intervals,comp);  
		
		res.add(intervals.get(0));  
		for(int i=1;i<intervals.size();i++)  
		{  
			if(res.get(res.size()-1).end>=intervals.get(i).start)  
			{  
				res.get(res.size()-1).end = Math.max(res.get(res.size()-1).end, intervals.get(i).end);  
			}  
			else  
			{  
				res.add(intervals.get(i));  
			}  
		}  
		return res;  
	}  
}