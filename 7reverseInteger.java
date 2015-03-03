/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

*/

public class Solution {
    public int reverse(int x) {
        int ret = 0;
        while (x != 0) {
            // handle overflow/underflow
            if (Math.abs(ret) > Integer.MAX_VALUE) {
                return 0;
            }
            ret = ret * 10 + x % 10;
            x /= 10;
        }
        return ret;
    }
}