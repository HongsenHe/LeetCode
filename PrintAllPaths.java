/*
问题：
给一个二叉树，把所有的路径都打印出来。
比如，对于下面这个二叉树，它所有的路径为：
8 -> 3 -> 1
8 -> 2 -> 6 -> 4
8 -> 3 -> 6 -> 7
8 -> 10 -> 14 -> 13

思路：
从根节点开始，把自己的值放在一个数组里，然后把这个数组传给它的子节点，
子节点同样把自己的值放在这个数组里，又传给自己的子节点，直到这个节点
是叶节点，然后把这个数组打印出来。所以，我们这里要用到递归。
*/

/*
Given a binary tree, prints out all of its root-to-leaf
paths, one per line. Uses a recursive helper to do the work.
*/
public void printPaths(Node root, int n) {
	String[] path = new String[n];
	printPaths(root, path, 0);
}
/*
Recursive printPaths helper -- given a node, and an array containing
the path from the root node up to but not including this node,
prints out all the root-leaf paths.
*/
private void printPaths(Node node, String[] path, int pathLen) {
	if (node == null) return;
    // append this node to the path array
	path[pathLen++] = node.value;
    // it's a leaf, so print the path that led to here
	if (node.leftChild == null && node.rightChild == null) {
		printArray(path, pathLen);
	}
	else {
	    // otherwise try both subtrees
		printPaths(node.leftChild, path, pathLen);
		printPaths(node.rightChild, path, pathLen);
	}
}
/*
Utility that prints strings from an array on one line.
*/
private void printArray(String[] ints, int len) {
	for (int i = 0; i < len; i++) {
		System.out.print(ints[i] + " ");
	}
	System.out.println();
}