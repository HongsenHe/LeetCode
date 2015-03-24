/*
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is 
rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 
3 different ways to solve this problem.

[show hint]

Hint:
Could you do it in-place with O(1) extra space?
Related problem: Reverse Words in a String II
*/

/*
1, 2, 3, 4, 5, 6, 7 -> 3, 2, 1, 4, 5, 6, 7
-> 3, 2, 1, 7, 6, 5, 4 -> 4, 5, 6, 7, 1, 2, 3
*/
public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int x = k % n;
        if (n == 1) {
            return;
        }
        if (x == 0) {
            return;
        }
        
        reverse(nums, 0, n - x);
        reverse(nums, n - x, n);
        reverse(nums, 0, n);
    }
    
    private void reverse(int[] nums, int start, int end) {
        int j = 0;
        for (int i = start; i < (end + start) / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[end - j - 1];
            nums[end - j - 1] = temp;
            j ++;
        }
    }
}