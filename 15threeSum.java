/*
Given an array S of n integers, are there elements a, b, c in S such 
that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/

/*
 * Known how to solove two sum, then traverse the array
 * the new target will be (sum - array[i])
 * and then using two sum strategy
 */
import java.util.*;
/*
 * the new target will be (sum - array[i])
 * and then using two sum strategy
 */
import java.util.*;

public class Solution { 
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(num);

		// in our case, the sum is 0, so the new target will be -array[i]
		int target = 0;

		for (int i = 0; i < num.length - 2; i++) {
			target = -num[i];
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int j = i + 1; j < num.length; j++) {
				if (map.containsKey(num[j])) {
					int index = map.get(num[j]);
					ArrayList<Integer> each = new ArrayList<Integer>();
					each.add(num[i]);
					each.add(num[index]);
					each.add(num[j]);
					result.add(each);

				} else {
					map.put(target - num[j], j);
				}
			}

		}

		// this is the key point for remove these duplicated elements
		HashSet hs = new HashSet();
		hs.addAll(result);
		result.clear();
		result.addAll(hs);

		return result;
	}
}

// another solution
/*
这道题是Two Sum的扩展，brute force时间复杂度为O(n^3), 对每三个数进行比较。这道题
和Two Sum有所不同，使用哈希表的解法并不是很方便，因为结果数组中元素可能重复，
如果不排序对于重复的处理将会比较麻烦，因此这道题一般使用排序之后夹逼的方法，
总的时间复杂度为O(n^2+nlogn)=(n^2),空间复杂度是O(n),代码如下：
*/

public class Solution {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num)  
	{  
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();  
		if(num==null || num.length<=2)  
			return res;  
		Arrays.sort(num);  
		for(int i=num.length-1;i>=2;i--)  
		{  
			if(i<num.length-1 && num[i]==num[i+1])  
				continue;  
			ArrayList<ArrayList<Integer>> curRes = twoSum(num,i-1,-num[i]);  
			for(int j=0;j<curRes.size();j++)  
			{  
				curRes.get(j).add(num[i]);  
			}  
			res.addAll(curRes);  
		}  
		return res;  
	}  
	private ArrayList<ArrayList<Integer>> twoSum(int[] num, int end,int target)  
	{  
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();  
		if(num==null || num.length<=1)  
			return res;  
		int l = 0;  
		int r = end;  
		while(l<r)  
		{  
			if(num[l]+num[r]==target)  
			{  
				ArrayList<Integer> item = new ArrayList<Integer>();  
				item.add(num[l]);  
				item.add(num[r]);  
				res.add(item);  
				l++;  
				r--;  
				while(l<r&&num[l]==num[l-1])  
					l++;  
				while(l<r&&num[r]==num[r+1])  
					r--;  
			}  
			else if(num[l]+num[r]>target)  
			{  
				r--;  
			}  
			else  
			{  
				l++;  
			}  
		}  
		return res;  
	}  

}
