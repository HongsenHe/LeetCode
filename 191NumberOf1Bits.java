/*
Write a function that takes an unsigned integer and returns the number of 
’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 
00000000000000000000000000001011, so the function should return 3.
*/

//https://leetcode.com/discuss/27609/short-code-of-c-o-m-by-time-m-is-the-count-of-1s
public class Solution {
    // you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int res = 0;
		while (n != 0) {
            //res += n & 1;
            //n >>= 1;
			
			n &= n - 1;
			res++;
		}
		
		return res;
	}
}