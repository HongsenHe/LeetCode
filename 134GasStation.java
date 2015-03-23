/*
There are N gas stations along a circular route, where the amount of gas 
at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to 
travel from station i to its next station (i+1). You begin the journey with
 an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the 
circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
*/

/*
思路：
1. 每一站的代价为gas-cost, 也就是求从哪一站开始累加代价和总是大于0。
一开始用了一个O（n^2）的解法，超时
2. 如果所有站的代价和大于0，则所求的路线必定存在。如果总代价〉=0,
从序号0开始求代价和，如果代价和小于0，则不是从本站或者本站之前的某
一个代价大于0的站开始，必从下一站即之后的站开始，而且这样的站必定
存在O（n）
*/
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0
            || cost.length == 0) {
                return -1;
            }
        int sum = 0;
        int total = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }
        
        if (total < 0) {
            return -1;
        } else {
            return start;
        }
    }
}