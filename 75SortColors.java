/*
Given an array with n objects colored red, white or blue, 
sort them so that objects of the same color are adjacent, 
with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the 
color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite 
array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
*/

/*
如果只能扫一遍，很容易想到的就是左边存放0和1，右边存放2.两边往中间靠。
设置两个index，ind1记录第一个1的位置，ind1左边为0，ind2记录第一个非2
的位置，ind2右边为2. 然后使用i从头到尾扫一遍，直到与ind2相遇。
i遇到0就换到左边去，遇到2就换到右边去，遇到1就跳过。

需要注意的是：由于ind1记录第一个1的位置，因此A[ind1]与A[i]交换后，
A[ind1]为0,A[i]为1，因此i++；
而ind2记录第一个非2的位置，可能为0或1，因此A[ind2]与A[i]交换后，
A[ind2]为2,A[i]为0或1，i不能前进，要后续判断。
由此该数组分为4段：
[0,ind1)-->0; [ind1,i)-->1; [i,ind2]-->乱序; (ind2,n-1]-->2

0  0  0  1  1  1  2  1  0  2  1  2  2  2

           ^         ^             ^

         ind1        i            ind2
*/
public class Solution {
    // solution 2, two pointers
    public void sortColors(int[] A) {
        int r = 0;
        int l = A.length - 1;
        
        int i = 0;
        while (i <= l) {
            if (A[i] == 0) {
                swap(A, i, r);
                i++;
                r++;
            } else if (A[i] == 1) {
                i++;
            } else {
                swap(A, i, l);
                l--;
            }
        }
    }
    
    // void method, must let A as a parameter. 
    private void swap (int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
    
    // solution 1 counting sort
    // public void sortColors(int[] A) {
    //     int r = 0;
    //     int w = 0;
    //     int b = 0;
        
    //     for (int i = 0; i < A.length; i++) {
    //         if (A[i] == 0) {
    //             r++;
    //         } else if (A[i] == 1) {
    //             w++;
    //         } else if (A[i] == 2) {
    //             b++;
    //         }
    //     }
        
    //     for (int j = 0; j < r; j++) {
    //         A[j] = 0;
    //     }
    //     for (int j = r; j < r + w; j++) {
    //         A[j] = 1;
    //     }
    //     for (int j = r + w; j < r + w + b; j++) {
    //         A[j] = 2;
    //     }
    // }
    
    
}