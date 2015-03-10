/*
Given a string S and a string T, find the minimum window in S which will contain 
all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will 
always be only one unique minimum window in S.
*/


// from ninechapter
public class Solution {
    public String minWindow(String S, String T) {
        if (S == null || S.length() == 0) {
            return S;
        }
        if (T == null || T.length() == 0) {
            return "";
        }
        
        HashMap <Character, Integer> tCounter = new HashMap<Character, Integer>();
        for (int i = 0; i < T.length(); i++) {
            Character c = T.charAt(i);
            if (tCounter.containsKey(c)) {
                tCounter.put(c, tCounter.get(c) + 1);
            } else {
                tCounter.put(c, 1);
            }
        }
        
        HashMap <Character, Integer> minWindowCounter = new HashMap<Character, Integer>();
        String minWindow = null;
        int tCount = 0, leftBound = 0;
        for (int i = 0; i < S.length(); i++) {
            Character c = S.charAt(i);
            if (!tCounter.containsKey(c)) {
                continue;
            }
            
            if (minWindowCounter.containsKey(c)) {
                minWindowCounter.put(c, minWindowCounter.get(c) + 1);
            } else {
                minWindowCounter.put(c, 1);
            }
            if (minWindowCounter.get(c) <= tCounter.get(c)) {
                tCount ++;
            }
            
            
            if (tCount == T.length()) {
                while (leftBound < S.length()) {
                    Character ch = S.charAt(leftBound);
                    if (!tCounter.containsKey(ch)) {
                        leftBound ++;
                        continue;
                    }
                    
                    if (minWindowCounter.get(ch) > tCounter.get(ch)) {
                        minWindowCounter.put(ch, minWindowCounter.get(ch) - 1);
                        leftBound ++;
                        continue;
                    }
                    
                    break;
                }
                
                if (minWindow == null || i - leftBound + 1 < minWindow.length()) {
                    minWindow = S.substring(leftBound, i + 1);
                }
            }
        }
        
        if (minWindow == null) {
            return "";
        }
        return minWindow;
    }
}