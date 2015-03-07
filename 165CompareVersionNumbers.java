/*
Compare two version numbers version1 and version2.
If version1 > version2 return 1, 
if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty 
and contain only digits and the . character.
The . character does not represent a decimal point and 
is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way 
to version three", it is the fifth second-level revision 
of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
*/


public class Solution {
    public int compareVersion(String version1, String version2) {
        // split . means every character, use \\.
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        
        int l1 = s1.length;
        int l2 = s2.length;
        int maxLength = Math.max(l1, l2);
        
        for(int i = 0; i < maxLength; i++){
            int v1 = 0;
            if(i < l1){
                v1 = Integer.parseInt(s1[i]);
            }
            
            int v2 = 0;
            if(i < l2){
                v2 = Integer.parseInt(s2[i]);
            }
            
            if(v1 < v2){
                return -1;
            }
            if(v1 > v2){
                return 1;
            }
        }
        
        return 0;
        
    }
}