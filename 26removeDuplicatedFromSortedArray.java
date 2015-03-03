/*
Given a sorted array, remove the duplicates in place 
such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must 
do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].

two pointer, i, j, once current node = next, move next cursor
once they are different, let current = A[i], once i hits end
done, and copy from 0 to j+1
*/

public class Solution {
    public int removeDuplicates(int[] A) {
    
	    if (A.length < 2)
		    return A.length;
 
	    int j = 0;
	    int i = 1;
 
	    while (i < A.length) {
		    if (A[i] == A[j]) {
			    i++;
		    } else {
			    j++;
			    A[j] = A[i];
		        i++;
		    }
	    }
 
	    int[] B = Arrays.copyOf(A, j + 1);
 
	    return B.length;
    }
}