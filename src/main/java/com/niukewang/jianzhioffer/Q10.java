package com.niukewang.jianzhioffer;

import javax.xml.soap.Node;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * @author JACKPOT
 */
public class Q10 {
    public static ListNode FindKthToTail(ListNode head, int k) {
        //如果倒数负数个节点或者head==null直接返回null
        if (k <= 0 || head == null) {
            return null;
        }
        //构建一个长度为k的数组,将链表的值按顺序插入到数组中,如果数组满了,就将数组的第一位舍弃,后面依次向前挪动一位
        //然后将插入到数组的最后一位.
        ListNode[] nodes = new ListNode[k];
        int flag = 0;
        while (head != null) {
            if (flag < k) {
                nodes[flag] = head;
            } else {
                //说明数组满了
                System.arraycopy(nodes, 1, nodes, 0, k - 1);
                nodes[k-1] = head;
            }
            flag++;
            head = head.next;
        }
        //如果数组没有填充满,说明k超过了链表的长度,没有的话数组的第一个值即为链表的倒数第k个
        if (k > flag) {
            return null;
        } else {
            return nodes[0];
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        ListNode tail = FindKthToTail(node, 2);
        System.out.println(tail);
    }
}
