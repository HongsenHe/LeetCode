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
这道题是判断一个字符串是不是回文串。因为只是看一个字符串，算法还是比较简单，
就是从两头出发，往中间走，进行两两匹配。这里面的小问题就是在这个题目要求中，
只判断字母和数字类型的字符，其他字符直接跳过即可。因此我们要写一个函数判断
他是不是合法字符，而且因为忽略大小写，我们在判断两个字符是不是相同的时候如
果是大写，要转成相应的小写字母。这个算法从两边扫描，到中间相遇，只需要一次
线性扫描，复杂度是O(n)，空间上是O(1)。代码如下：
*/
public class Solution {
    // public boolean isPalindrome(String s) {
    //     boolean result = true;
    //     if(s == null){
    //         return false;
    //     }
        
    //     StringBuffer sb = new StringBuffer();
    //     s = s.toUpperCase();
    //     char[] sChar = s.toCharArray();
    //     for(int i = 0; i < sChar.length; i++){
    //         if(Character.isLetterOrDigit(sChar[i])){
    //             sb.append(sChar[i]);
    //         }
    //     }
    //     String s1 = sb.toString();
        
    //     char[] s1Char = s1.toCharArray();
    //     for(int j = 0; j < s1Char.length/2; j++){
    //         if(s1Char[j] != s1Char[s1Char.length-1-j]){
    //             result = false;
    //             break;
    //         }
    //     }
        
    //     return result;
    // }
    
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int l = 0;
        int r = s.length() - 1;
        
        while (l < r) {
            if (!isValid(s.charAt(l))){
                l++;
                continue;
            }
            if (!isValid(s.charAt(r))) {
                r--;
                continue;
            }
            if (!isSame(s.charAt(l), s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    
    private boolean isValid (char c) {
        if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z'
            || c >= '0' && c <= '9') {
                return true;
        }
        return false;
    }

    private boolean isSame (char c1, char c2) {
        // convert from uppercase to lowercase
        if (c1 >= 'A' && c1 <= 'Z') 
            c1 = (char)(c1 + 32);
        if (c2 >= 'A' && c2 <= 'Z') 
            c2 = (char)(c2 - 'A' + 'a');
        return c1 == c2;
    }
    
}
