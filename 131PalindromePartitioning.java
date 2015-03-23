/*
Given a string s, partition s such that every substring of the partition 
is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
*/

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        ArrayList<String> path = new ArrayList<String>();
        if (s == null) {
            return res;
        }
        helper(path, res, 0, s);
        return res;
    }
    
    void helper(ArrayList<String> path, List<List<String>> res, int pos, String s) {
        if (pos == s.length()) {
            res.add(new ArrayList<String>(path));
            return;
        }
        
        for (int i = pos + 1; i <= s.length(); i++) {
            String prefix = s.substring(pos, i);
            if (!isPalindrome(prefix)) {
                continue;
            }
            
            path.add(prefix);
            helper(path, res, i, s);
            path.remove(path.size() - 1);
        }
    }
    
    boolean isPalindrome(String t) {
        int start = 0;
        int end = t.length() - 1;
        while (start <= end) {
            if (t.charAt(start) != t.charAt(end)) {
                return false;
            }
            start ++;
            end --;
        }
        return true;
    } 
}