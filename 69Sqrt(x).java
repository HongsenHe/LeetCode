/*
Implement int sqrt(int x).

Compute and return the square root of x.
*/

/*
 * 1. binary search
 * 2. Newton Iteration...
 */
public class Solution {
    public int sqrt(int x) {
        // long right = 0;
        // long left = x;
        
        // while (left >= right) {
        //     long mid = left + (right - left) / 2;
        //     if (x < mid * mid) {
        //         right = mid - 1;
        //     } else {
        //         left = mid + 1;
        //     }
            
        // }
        // return (int) right;
        double ans = x;
        while(Math.abs(ans * ans - x) > 0.0001) {
             ans = (ans + x / ans) / 2;
        }
         
        return (int)ans;
    }
}