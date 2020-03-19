package com.niukewang.jianzhioffer;
/**
 *输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则
 * @author JACKPOT
 */
public class Q12 {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        ListNode list5 = new ListNode(5);
        ListNode list6 = new ListNode(6);
        list1.next = list2;
        list2.next = list3;
        //list.next = list4;
        list4.next = list5;
        list5.next = list6;


        Q12 q12 = new Q12();

        ListNode merge = q12.merge(list4, list1);
        System.out.println(merge);

    }


    /***
     * 将list2插入到list1中
     * @param list1 目标数组 每次递归都会增加一个节点
     * @param list2 要插入的数组 每次递归都会减少一个节点
     * @return
     */
    public ListNode merge(ListNode list1, ListNode list2){
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        //保存list1从头结点开始的引用,因为list1后面是变化的,list2同理
        ListNode list1Temp = list1;
        ListNode list2Temp = list2;
        int list1FirstVal = list1.val;
        int list2FirstVal = list2.val;

        //判断list1只有一个节点的情况
        if (list1.next == null){
            //说明list1只有一个节点,那么这个节点也是最后一个节点
            if (list2FirstVal>=list1FirstVal){
                //如果list1最后一个节点也就是最大De节点都比list2头节点也就是最小的节点小
                list1.next = list2;
                return list1;
            }else{
                return merge(list2,list1);
            }
        }
        if (list2FirstVal<=list1FirstVal){
            ListNode list2Next = list2.next;
            list2.next = list1;
            list1 = list2Temp;
            list2 =list2Next;
            return merge(list1,list2);
        }else{
            while(true){
                ListNode list1Next = list1.next;
                if (list1Next==null){
                    //说明循环到了list1最后一个节点,但还没没有找到合适的两个节点,说明list1最后一个节点都比list2第一个节点小
                    list1.next = list2;
                    return list1Temp;
                }
                //找到list1中合适的两个节点
                int list1NextVal = list1Next.val;
                if (list1FirstVal <= list2FirstVal && list1NextVal >= list2FirstVal) {
                    //说明找到了,将list2第一个节点插入到list1两个节点中间
                    list2 = list2.next;
                    list1.next = list2Temp;
                    list2Temp.next = list1Next;
                    return merge(list1Temp,list2);
                }else{
                    //说明第一次循环没找到
                    list1 = list1.next;
                    list1FirstVal = list1.val;
                }
            }
        }
    }


    /*public ListNode Merge(ListNode list1,ListNode list2) {
        //新建一个头节点，用来存合并的链表。
        ListNode head=new ListNode(-1);
        head.next=null;
        ListNode root=head;
        while(list1!=null&&list2!=null) {
            if(list1.val<list2.val){
                head.next=list1;
                head=list1;
                list1=list1.next;
            }
            else {
                head.next=list2;
                head=list2;
                list2=list2.next;
            }
        }
        //如果有一个链表为空，另一个链表非空，则应该把非空链表合并到链表尾部。
        if(list1!=null) {
            head.next=list1;
        }
        if(list2!=null) {
            head.next=list2;
        }
        return root.next;

    }*/
}
