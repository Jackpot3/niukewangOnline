package com.niukewang.jianzhioffer;

import java.util.ArrayList;
import java.util.Collections;

/***
 * 题目描述
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * @author JACKPOT
 */
public class Q3 {
    public static void main(String[] args) {
        int[] a = new int[2];

    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> resultList = new ArrayList();

        while (listNode != null) {
            resultList.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(resultList);
        return resultList;
    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

