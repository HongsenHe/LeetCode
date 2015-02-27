/*
Given a string s consists of upper/lower-case alphabets and
 empty space characters ' ', return the length of last word 
 in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of 
non-space characters only.

For example, 
Given s = "Hello World",
return 5.
*/

/*
find space from the end, and find space2 from space1
return space2 - space1
*/
public class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int index = s.length()-1;
        while(index >= 0 && s.charAt(index) == ' '){
            index--;
        }
        int index2 = index;
        while(index2 >= 0 && s.charAt(index2) != ' '){
            index2--;
        }
        
        return index-index2;
    }
}