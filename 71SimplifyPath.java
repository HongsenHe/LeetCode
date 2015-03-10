/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
*/

/*
initial result = /
if meet . or "" do nothing 
if meet .. go back, delete
store dict into an arraylist
add each element with /
but delete the last /, return
*/
public class Solution {
	public String simplifyPath(String path) {
		String result = "/";
		String pathArr[] = path.split("/");
		
		ArrayList<String> paths = new ArrayList<String>();
		for (String s: pathArr) {
			if (s.equals("..")) {
				if (paths.size() > 0) {
					paths.remove(paths.size() - 1);
				}
			} else if (!s.equals(".") && !s.equals("")) {
				paths.add(s);
			}
		}
		
		for (String s: paths) {
			result += s + "/";
		}
		
		if (result.length() > 1) {
			result = result.substring(0, result.length() - 1);
		}
		
		return result;
	}
}

/*
又是一个字符串处理题。
面对这种题目一定要保持清醒，先分析好题目之后再开始码代码。
题目的要求是输出Unix下的最简路径，Unix文件的根目录为"/"，"."表示当前目录，".."表示上级目录。
例如：
输入1：
/../a/b/c/./.. 
输出1：
/a/b
模拟整个过程：
1. "/" 根目录
2. ".." 跳转上级目录，上级目录为空，所以依旧处于 "/"
3. "a" 进入子目录a，目前处于 "/a"
4. "b" 进入子目录b，目前处于 "/a/b"
5. "c" 进入子目录c，目前处于 "/a/b/c"
6. "." 当前目录，不操作，仍处于 "/a/b/c"
7. ".." 返回上级目录，最终为 "/a/b"

我用一个堆栈来模拟路径的行为，遇到"."不操作，遇到".."退栈，其他情况都压入堆栈。
P.S.
有以"."开头的路径，例如："/.fdfd"。
*/