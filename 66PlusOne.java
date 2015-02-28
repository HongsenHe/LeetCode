/*
Given a non-negative number represented as an
 array of digits, plus one to the number.

The digits are stored such that the most significant 
digit is at the head of the list.
*/

public class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length -1;
        int flag = 0;
        while(i >= 0){
            if(digits[i] + 1 > 9){
                digits[i] = 0;
                flag = 1;
                i--;
            }
            else{
                digits[i] += 1;
                return digits;
            }
        }
        
        if(flag == 1){
            int[] newDigits = new int[digits.length+1];
            System.arraycopy(digits,0,newDigits,1,digits.length);
            newDigits[0] = 1;
            newDigits[1] = 0;
            return newDigits;
        }
        
        return digits;
    }
}