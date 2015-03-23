/*
Given an array S of n integers, are there elements a, b, c, and d in S such 
that a + b + c + d = target? Find all unique quadruplets in the array which 
gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. 
(ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
*/

/*
上述这种方法比较直接，根据3Sum的结果很容易进行推广。那么时间复杂度能不能更好呢？其实我们可以
考虑用二分法的思路，如果把所有的两两pair都求出来，然后再进行一次Two Sum的匹配，我们知道T
wo Sum是一个排序加上一个线性的操作，并且把所有pair的数量是O((n-1)+(n-2)+...+1)=O(n(n-1)/2)=O(n^2)。
所以对O(n^2)的排序如果不用特殊线性排序算法是O(n^2*log(n^2))=O(n^2*2logn)=O(n^2*logn)，
算法复杂度比上一个方法的O(n^3)是有提高的。
思路虽然明确，不过细节上会多很多情况要处理。首先，我们要对每一个pair建一个数据结构来存储元素的值
和对应的index，这样做是为了后面当找到合适的两对pair相加能得到target值时看看他们是否有重叠的index，
如果有说明它们不是合法的一个结果，因为不是四个不同的元素。接下来我们还得对这些pair进行排序，所以要
给pair定义comparable的函数。最后，当进行Two Sum的匹配时因为pair不再是一个值，所以不能像Two Sum
中那样直接跳过相同的，每一组都得进行查看，这样就会出现重复的情况，所以我们还得给每一个四个元素组成的
tuple定义hashcode和相等函数，以便可以把当前求得的结果放在一个HashSet里面，这样得到新结果如果是重
复的就不加入结果集了。
*/
public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        //Create the dictionary.
        HashMap<Integer, ArrayList<ArrayList<Integer>>> dict = new HashMap<>();
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int sum = num[i] + num[j];
                ArrayList<Integer> pair = new ArrayList<>(2);
                pair.add(i);
                pair.add(j);
                if (!dict.containsKey(sum)) {
                    ArrayList<ArrayList<Integer>> value = new ArrayList<>();
                    value.add(pair);
                    dict.put(sum, value);
                } else {
                    ArrayList<ArrayList<Integer>> value = dict.get(sum);
                    value.add(pair);
                }
            }
        }
        //Use HashSet to prevent duplicate result.
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        for (Integer sum : dict.keySet()) {
            ArrayList<ArrayList<Integer>> sumPair = dict.get(sum);
            if (dict.containsKey(target - sum)) {
                if (target - sum == sum && sumPair.size() == 1)
                    continue;
                ArrayList<ArrayList<Integer>> pairs = dict.get(target - sum);
                for (ArrayList<Integer> pair1 : sumPair) {
                    for (ArrayList<Integer> pair2 : pairs) {
                        //Make sure it is not the same pair.
                        if (pair1 == pair2)
                            continue;
                        //Make sure there is no same element in two pairs.
                        if (pair1.contains(pair2.get(0)) || pair1.contains(pair2.get(1)))
                            continue;
                        ArrayList<Integer> tmpResult = new ArrayList<>(4);
                        tmpResult.add(num[pair1.get(0)]);
                        tmpResult.add(num[pair1.get(1)]);
                        tmpResult.add(num[pair2.get(0)]);
                        tmpResult.add(num[pair2.get(1)]);
                        //Sort the list and add it into the set.
                        Collections.sort(tmpResult);
                        set.add(tmpResult);
                    }
                }
            }
        }
        List<List<Integer>> ret = new LinkedList<>();
        ret.addAll(set);
        return ret;
    
    }
}

/*
public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);

		for (int i = 0; i < num.length - 3; i++) {
			if (i != 0 && num[i] == num[i - 1]) {
				continue;
			}

			for (int j = i + 1; j < num.length - 2; j++) {
				if (j != i + 1 && num[j] == num[j - 1])
					continue;

				int left = j + 1;
				int right = num.length - 1;
				while (left < right) {
					int sum = num[i] + num[j] + num[left] + num[right];
					if (sum < target) {
						left++;
					} else if (sum > target) {
						right--;
					} else {
						ArrayList<Integer> tmp = new ArrayList<Integer>();
						tmp.add(num[i]);
						tmp.add(num[j]);
						tmp.add(num[left]);
						tmp.add(num[right]);
						rst.add(tmp);
						left++;
						right--;
						while (left < right && num[left] == num[left - 1]) {
							left++;
						}
						while (left < right && num[right] == num[right + 1]) {
							right--;
						}
					}
				}
			}
		}

		return rst;
	}
*/