/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct
ways can you climb to the top?
*/

public class Solution {
    // recursion, TLE
    // public int climbStairs(int n) {
    //     if (n == 0 ||n == 1 || n == 2 ) {
    //         return n;
    //     }
    //     return climbStairs(n-1) + climbStairs(n-2);
    // }
    
    // DP
    public int climbStairs(int n) {
        if (n < 2) {
            return n;
        }
        int[] step = new int[n];
        step[0] = 1;
        step[1] = 2;
        
        for (int i = 2; i < n; i++) {
            step [i] = step[i-1] + step[i-2];
        }
        
        return step[n-1];
    }

    // DP 2
    public int climbStairs(int n) {
        if (n <= 2){
            return n;
        }
        int [] step = new int[n+1];
        step[0] = 0;
        step[1] = 1;
        step[2] = 2;
        for (int i = 3; i <= n; i++) {
            step[i] = step[i-1] + step[i-2];
        }
        return step[n];
    }
    
    /*
    下面采用非递归的方法，其中pre代表前n-1台阶的方法数，current代表第n台阶的方法数。
    Space = O(1)
    */
    public int climbStairs(int n) {
        if (n == 0 || n == 1)
            return 1;
        int pre = 1;
        int current = 1;
        for (int i = 2; i <= n; i++) {
            int temp = current + pre;
            pre = current;
            current = temp;
        }
        return current;
    }
}