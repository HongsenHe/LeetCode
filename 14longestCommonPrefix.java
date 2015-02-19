/*
Write a function to find the longest common prefix string amongst an array of strings.
*/

public class Solution {
	public String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0){
			return "";
		}
		
		int flag = 0;
		int index = 0;
		StringBuffer sb = new StringBuffer();
		
		while(flag == 0){
			for(int i = 0; i < strs.length; i++){
				if((strs[i].length() <= index) || strs[i].charAt(index) != strs[0].charAt(index))
				{
					flag = 1;
					break;
				}
			}
			
			if(flag == 0){
				sb.append(strs[0].charAt(index));
			}
			
			index++;
		}
		
		return sb.toString();
	}
}