package datastructure.stack;

import java.util.ArrayList;
import java.util.List;

class MinStack {

    private final List<Integer> data;
    private int index;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        data = new ArrayList<>();
        index = -1;
    }

    public void push(int x) {
        data.add(x);
        index++;
    }

    public void pop() {
        data.remove(index--);
    }

    public int top() {
        return data.get(index);
    }

    public int getMin() {
        int min = data.get(index);
        for (int i = 0; i < data.size(); i++) {
            if (min > data.get(i)) {
                min = data.get(i);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
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