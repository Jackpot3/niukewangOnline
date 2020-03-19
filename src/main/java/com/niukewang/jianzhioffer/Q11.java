package com.niukewang.jianzhioffer;

import com.niukewang.utils.TimeWatch;

import java.util.Stack;
/**
 *输入一个链表，反转链表后，输出新链表的表头。
 * @author JACKPOT
 */
public class Q11 {

    public ListNode ReverseList(ListNode head) {

        if(head==null){
            return null;
        }

        Stack<ListNode> nodes = new Stack<>();
        while(head!=null){
            nodes.push(head);
            ListNode next = head.next;
            //放弃对象之间的引用关系,避免循环引用
            head.next = null;
            head = next;
        }
        ListNode newHead = nodes.peek();
        head = nodes.pop();
        while(!nodes.isEmpty()){
            ListNode next = nodes.pop();
            head.next = next;
            head = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        Q11 q11 = new Q11();
        TimeWatch.begin();
        ListNode node = q11.ReverseList(a);
        TimeWatch.end();
        System.out.println(node.val);
    }
}
