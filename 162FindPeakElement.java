/*
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a 
peak element and return its index.

The array may contain multiple peaks, in that case return 
the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your
 function should return the index number 2.

click to show spoilers.

Note:
Your solution should be in logarithmic complexity.
*/

public class Solution {
    public int findPeakElement(int[] num) {
     
       int left=0,right=num.length-1;  
        while(left<=right){  
            if(left==right)  
                return left;  
            int mid=(left+right)/2;  
            if(num[mid]<num[mid+1])  
                left=mid+1;  
            else  
                right=mid;  
        }  
        return -1;
    }
}