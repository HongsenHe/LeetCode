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
