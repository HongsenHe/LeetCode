/*
Given a string, determine if it is a palindrome, 
considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This 
is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/

/*
step1, remove symbols, step2. compare from 0 and end index
*/
public class Solution {
    public boolean isPalindrome(String s) {
        boolean result = true;
        if(s == null){
            return false;
        }
        
        StringBuffer sb = new StringBuffer();
        s = s.toUpperCase();
        char[] sChar = s.toCharArray();
        for(int i = 0; i < sChar.length; i++){
            if(Character.isLetterOrDigit(sChar[i])){
                sb.append(sChar[i]);
            }
        }
        String s1 = sb.toString();
        
        char[] s1Char = s1.toCharArray();
        for(int j = 0; j < s1Char.length/2; j++){
            if(s1Char[j] != s1Char[s1Char.length-1-j]){
                result = false;
                break;
            }
        }
        
        return result;
    }
}