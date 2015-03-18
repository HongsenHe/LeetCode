/*
Given two strings S and T, determine if they are both one edit distance apart.
*/

public class Solution {
    public boolean isOneEditDistance(String s, String t) {
       
       // if s and t are the same string. return false
        if ((s == null && t == null) || (s.length() == 0 && t.length() == 0) || s.equals(t)) {
            return false;
        }
        
        // select the small string
        String small = s.length() <= t.length() ? s : t;
        String large = s.length() <= t.length() ? t : s;

        int operations = 0;
        if (large.length() - small.length() > 1) {
            return false;
        } else if (large.length() == small.length()) { 
            for (int i = 0; i < small.length(); i++) {
                if (small.charAt(i) != large.charAt(i) && ++operations > 1) {
                    return false;
                }
            }
        } else {
            int i = 0;
            while (i < small.length()) {
                if (small.charAt(i) != large.charAt(i + operations)) {
                    if (++operations > 1)
                        return false;
                } else {
                    i++;
                }
            }
        }   

        return true;
    }
}