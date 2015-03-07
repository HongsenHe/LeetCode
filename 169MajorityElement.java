/*
Given an array of size n, find the majority element. 
The majority element is the element that appears more
 than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the 
majority element always exist in the array.
*/

/*
 * Solution one is sorting the array, then return mid
 * Solution two is voting. remove a pair of diff nums
 * Then the rest of elem is the majority elem(s).
 */

public class Solution {
    // public int majorityElement(int[] num) {
    //     Arrays.sort(num);  
    //     return num[num.length/2]; 
    // }
    
    public int majorityElement(int[] num) {
        int maj = 0;
        int count = 0;
        for (int i = 0; i < num.length; i++) {
            if (count == 0) {
                maj = num[i];
                count ++;
            } else {
                if (maj == num[i]) {
                    count ++;
                } else {
                    count --;
                }
            }
        }
        return maj;
    }
}