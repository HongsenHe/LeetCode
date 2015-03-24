/*

Design a stack that supports push, pop, top, and retrieving the minimum 
element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/

/*
这道题的关键之处就在于 minStack 的设计，push() pop() top() 这些操作
Java内置的Stack都有，不必多说。

我最初想着再弄两个数组，分别记录每个元素的前一个比它大的和后一个比
它小的，想复杂了。

第一次看上面的代码，还觉得它有问题，为啥只在 x<minStack.peek() 时压栈
？如果，push(5), push(1), push(3) 这样minStack里不就只有5和1，这样
pop()出1后， getMin() 不就得到5而不是3吗？其实这样想是错的，因为要
想pop()出1之前，3就已经被pop()出了。. 

minStack 记录的永远是当前所有元素中最小的，无论 minStack.peek() 
在stack 中所处的位置。
*/
class MinStack {
    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();
    
    public void push(int x) {
        // always insert the smaller one
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }    
        stack.push(x);
    }

    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
