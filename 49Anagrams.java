/*
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.
*/

/*
分析
对字符串中各字母进行排序，那么互为重排列的字符串就会相等。

按照上述思路，用一个map纪录按字母排序后的字符串及其出现位置（或原字符串），
在遍历过程中，如果遇到排序后的字符串相等的，就说明两者互为重排列。

第一次出现的重排列字符串需要特殊照顾下，下述代码中用-1标识第一次出现的
重排列字符串是否已经加入结果。

此外，对字符串按字母排序的方法可以用Java类库的char数组排序；也可以
利用题目所说的字符串中只含有小写字母这一信息，进行计数排序。
*/

/*
例如：
S = ["abc", "bca", "bac", "bbb", "bbca", "abcb"]
答案为：
["abc", "bca", "bac", "bbca", "abcb"]
只有"bbb"没有相同字母组成的单词。
*/
public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> list = new ArrayList<String>();
        HashMap<String, Integer> records = new HashMap<String, Integer>();
        
        for (int i = 0; i < strs.length; ++i) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String anagram = new String(chars);
            
            if (records.containsKey(anagram)) {
                int index = records.get(anagram);
                
                if (index != -1) {
                    list.add(strs[index]);
                    records.put(anagram, -1);
                }
                
                list.add(strs[i]);
            } else {
                records.put(anagram, i);
            }
        }
    
        return list;
    }
}