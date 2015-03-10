/*
Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

/*
Subset这道题的条件比较直观，就是每当我们添加了一个元素，都是一个新的子集。
那么我们怎么保证不会出现重复集合呢。我们引入一个int pos用来记录此子集的
起点在哪，比如当pos = 1的时候就是从第二个元素往后循环添加元素（0 base）,
每次当此层用了第i个元素，那么下一层需要传入下一个元素的位置i+1 除此之外，
当循环结束要返回上一层dfs的时候我们需要把这一层刚添加元素删去。

比如输入集合为［1，2，3］应当是这么运行，

[]

[1]

[1,2]

[1,2,3] //最底层子循环到头返回删去3，上一层的子循环也到头删去2

          //而此时，这一层循环刚到2，删去后还可以添加一个3

[1,3] //删除3，删除1

[2]

[2,3] //删除3，删除2

[3]


*/

public class Solution {
	public List<List<Integer>> subsets(int[] S) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (S == null || S.length == 0) {
			return res;
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		Arrays.sort(S);
		helper(res, list, S, 0);
		
		return res;
	}
	
	private void helper(List<List<Integer>> res, ArrayList<Integer> list, int[] s, int pos){
        // add immediately
		res.add(new ArrayList<Integer>(list));
		
		for (int i = pos; i < s.length; i++) {
			list.add(s[i]);
            // key point, only find next
			helper(res, list, s, i + 1);
			list.remove(list.size() - 1);
		}
	}
}