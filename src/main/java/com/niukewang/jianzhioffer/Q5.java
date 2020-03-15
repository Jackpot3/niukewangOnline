package com.niukewang.jianzhioffer;

import java.util.Stack;

/***
 * 两个栈模拟一个队列
 * @author JACKPOT
 */
public class Q5 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int returnVal = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return returnVal;
    }
}
