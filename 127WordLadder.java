/*
Given two words (start and end), and a dictionary, find the length of shortest 
transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
*/

/*
http://blog.csdn.net/zxzxy1988/article/details/8591890

*/
public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (dict.size() == 0) 
            return 0;
        LinkedList<String> queue = new LinkedList<String>();
        String tag = new String();
        queue.add(start);
        queue.add(tag);
        int len = 1;
        while(queue.size() > 1){
            String top = queue.pop();
            if(top == tag){
                len++;
                queue.add(tag);
                continue;
            }
            if(top.equals(end)){

                return len;
            }
            for(int i=0; i<top.length(); i++){
                char[] currCharArr = top.toCharArray();
                for(char c='a'; c<='z'; c++){
                    currCharArr[i] = c;
                    String newWord = new String(currCharArr);
                    if(dict.contains(newWord)){
                        queue.add(newWord);
                        dict.remove(newWord);//删除掉遍历过的单词
                    }
                }
            }
        }
        return 0;

    }
}