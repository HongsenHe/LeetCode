/*
Determine whether an integer is a palindrome. Do this without extra space.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
*/

public class Solution {
	public boolean isPalindrome(int x) {
		int y = 0;
		int sign = 0;
		if(x < 0){
			return false;
		}
		int k = Math.abs(x);
		while(k > 0){
			if(y > Integer.MAX_VALUE){
				return false;
			}
			y = k%10 + 10*y;
			k /= 10;
		}
		if(y == x){
			return true;
		}else{
			return false;
		}
		
	}
}