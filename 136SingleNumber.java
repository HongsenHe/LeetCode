/*
Given an array of integers, every element appears twice 
except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. 
Could you implement it without using extra memory?
*/

/* a^b = b^a, a^(b^c) = (a^b)^c, a^a = 0, a^0 = a, 0^0 = 0
 * 1,4,3,1,4: 1^4^3^1^4 = 1^1^3^3^4 = 0^0^4 = 4, return 4
 */
public class Solution {
    public int singleNumber(int[] A) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            res = res ^ A[i];
        }
        return res;
    }
}