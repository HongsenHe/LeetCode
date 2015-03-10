/*
Given a string S, find the longest palindromic substring in S. 
You may assume that the maximum length of S is 1000, 
and there exists one unique longest palindromic substring.
*/

/*
这道题是比较常考的题目，求回文子串，一般有两种方法。 第一种方法比较直接，
实现起来比较容易理解。基本思路是对于每个子串的中心（可以是一个字符，或者
是两个字符的间隙，比如串abc,中心可以是a,b,c,或者是ab的间隙，bc的间隙）
往两边同时进行扫描，直到不是回文串为止。假设字符串的长度为n,那么中心的个数
为2*n-1(字符作为中心有n个，间隙有n-1个）。对于每个中心往两边扫描的复杂度
为O(n),所以时间复杂度为O((2*n-1)*n)=O(n^2),空间复杂度为O(1)，代码如下：

*/
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        int maxLen = 0;
        String res = "";
        
        for (int i = 0; i < 2 * s.length() - 1; i++) {
            int left = i/2;
            int right = i/2;
            if (i%2 == 1) {
                right++;
            }
            
            String str = helper(s, left, right);
            if (maxLen < str.length()) {
                maxLen = str.length();
                res = str;
            }
        }
        return res;
    }
    
    private String helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        return s.substring(left + 1, right);
    }
}

/*
而第二种方法是用动态规划，思路比较复杂一些，但是实现代码会比较简短。基本思路是外层
循环i从后往前扫，内层循环j从i当前字符扫到结尾处。过程中使用的历史信息是从i+1到n之间
的任意子串是否是回文已经被记录下来，所以不用重新判断，只需要比较一下头尾字符即可。
这种方法使用两层循环，时间复杂度是O(n^2)。而空间上因为需要记录任意子串是否为回文，
需要O(n^2)的空间，代码如下：

综上所述，两种方法的时间复杂度都是O(n^2)。而空间上来看第一种方法是常量的，比第二种
方法优。这个题目中假设最长回文子串只有一个，实际面试中一般不做这种假设，如果要返回
所有最长回文串，只需要稍做变化就可以，维护一个集合，如果等于当前最大的，即加入集合，
否则，如果更长，则清空集合，加入当前这个。实际面试会有各种变体，感觉平常还是要多想
才行。
*/

/*
public String longestPalindrome(String s) {  
    if(s == null || s.length()==0)  
        return "";  
    boolean[][] palin = new boolean[s.length()][s.length()];  
    String res = "";  
    int maxLen = 0;  
    for(int i=s.length()-1;i>=0;i--)  
    {  
        for(int j=i;j<s.length();j++)  
        {  
            if(s.charAt(i)==s.charAt(j) && (j-i<=2 || palin[i+1][j-1]))  
            {  
                palin[i][j] = true;  
                if(maxLen<j-i+1)  
                {  
                    maxLen=j-i+1;  
                    res = s.substring(i,j+1);  
                }  
            }  
        }  
    }  
    return res;  
}  
*/