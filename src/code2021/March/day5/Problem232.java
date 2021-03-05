/*
 * Copyright (c) 2021 maoyan.com
 * All rights reserved.
 *
 */
package code2021.March.day5;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 * 可能是比较蠢的做法  两栈 push为1号 pop为2号。 每次搞之前倒一下数据 O(n)的复杂度 显然比较慢 应该有O(1)的做法 看看题解
 *
 * @author chenhang
 * @created 2021/3/5
 */
public class Problem232 {

}

class MyQueue {

    private Stack<Integer> put = new Stack<>();
    private Stack<Integer> get = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (put.isEmpty()) {
            while (!get.isEmpty()) {
                put.add(get.pop());
            }
        }
        put.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (get.isEmpty()) {
            while (!put.isEmpty()) {
                get.add(put.pop());
            }
        }
        return get.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (get.isEmpty()) {
            while (!put.isEmpty()) {
                get.add(put.pop());
            }
        }
        return get.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return get.isEmpty() && put.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */