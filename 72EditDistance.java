/*
Given two words word1 and word2, find the minimum number of steps 
required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character

*/

public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length() + 1;
        int n = word2.length() + 1;
        
        int [][] edit = new int[m][n];
        // initialize
        for (int i = 0; i < m; i++) {
            edit[i][0] = i;
        }
        
        for (int j = 0; j < n; j++) {
            edit[0][j] = j;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    edit [i][j] = edit[i-1][j-1];
                } else {
                    edit[i][j] = Math.min(edit[i-1][j-1] + 1, Math.min(edit[i][j-1] + 1, edit[i-1][j] + 1));
                }
            }
        }
        
        return edit[m-1][n-1];
    }
}

/*
先给一个例子，两个字符串eeba和abca相似度是多少呢，edit distance是一个很好的度量，定义从字符串a变到字符串b，
所需要的最少的操作步骤（插入，删除，更改）为两个字符串之间的编辑距离。

对于eeba,abca它们之间的编辑距离为3，可以按照上面的操作步骤（不是唯一的）将eeba变到abca，1.将e变为a 2.删除e 3.添加c 共3个步骤。

典型的动态规划问题。

image

EDIT[i,j]表示对于字符串a从1到i的子串和字符串b从1到j的字串的编辑距离。（字符串下标从1开始)

EDIT[i - 1,j] + 1表示对a 在i 位置删除delete操作

EDIT[i,j - 1] + 1 表示insert添加操作

EDIT[i-1, j - 1] + f(x[i],y[j])这里如果x[i] == y[j] 则 f(x[i],y[j]) == 0 否则 ==1

表示不变或者是modify操作。

*/