package com.leetcode;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummySmall = new ListNode(0);
        ListNode dummyBig = new ListNode(0);
        
        ListNode curr1 = dummySmall;
        ListNode curr2 = dummyBig;
        while(head != null){
            if(head.val >= x){
                curr2.next = head;
                curr2 = head;
            }
            else{
                curr1.next = head;
                curr1 = head;
            }
            
            head = head.next;
        }
        
        curr1.next = dummyBig.next;
        curr2.next = null;//otherwise there may be a cycle!!!
        return dummySmall.next;
    }
}
