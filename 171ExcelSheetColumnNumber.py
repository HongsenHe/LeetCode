'''
Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
'''
class Solution:
    # @param s, a string
    # @return an integer
    def titleToNumber(self, s):
        res = 0;
        for i in range (0, len(s)):
            digit = ord(s[i]) - 64;
            res = res * 26 + digit;
        return res;