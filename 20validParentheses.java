/*
Given a string containing just the characters '(', ')', '{', '}', 
'[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" 
are all valid but "(]" and "([)]" are not.

create a stack. for all character. if left -> push. then three else if
if right is in stack, and pop is its left, true; and is not break
*/

	public class Solution {
		public boolean isValid(String s) {
			boolean result = false;
			Stack<Character> a = new Stack<Character> ();
			char [] b = s.toCharArray();

			for(int i = 0; i < b.length; i++){
				if(b[i] == '(' || b[i] == '[' || b[i] == '{'){
					a.push(b[i]);
				}

				else if((b[i] == ')') && !a.empty() && a.pop() == '('){
					result = true;

				}

				else if((b[i] == ']') && !a.empty() && a.pop() == '['){
					result = true;

				}

				else if((b[i] == '}') && !a.empty() && a.pop() == '{'){
					result = true;
				}else{
					result = false;
					break;
				}
			}

			if(!a.empty()){
				result = false;
			}

			return result;
		}
	}