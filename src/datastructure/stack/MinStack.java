package datastructure.stack;

import java.util.ArrayList;
import java.util.List;

class MinStack {

    private final List<Integer> data;
    private int index;

    private final List<Integer> minList;
    private int minIndex;
    private int min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        data = new ArrayList<>();
        minList = new ArrayList<>();
        index = -1;
        minIndex = -1;
    }

    public void push(int x) {
        if (minList.isEmpty() || min >= x) {
            min = x;
            minList.add(min);
            minIndex++;
        }
        data.add(x);
        index++;
    }

    public void pop() {
        int r = data.remove(index--);
        if (!minList.isEmpty() && r == minList.get(minIndex)) {
            minList.remove(minIndex--);
            if(minIndex >= 0){
                min = minList.get(minIndex);
            }
        }
    }

    public int top() {
        return data.get(index);
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.push(2147483647);
        minStack.pop();
        minStack.push(-2147483648);
        minStack.pop();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */