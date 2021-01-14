package com.leetcode;

/*
给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例 1:

给定链表 1->2->3->4, 重新排列为 1->4->2->3.
示例 2:

给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.

来源：力扣（LeetCode）
*/

public class ReorderList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        ListNode head = linkedList.createLinkedList(10000000);
        show(head);
        System.out.println();
        reorderList(head);
    }

    public static void reorderList(ListNode head) {
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        ListNode temp = head;
        int len = 1;
        while (temp.next != null) {
            len++;
            temp = temp.next;
        }

        ListNode slow = head;
        ListNode rapid = head;
        int slowIndex = 0;
        if (slow.next == null) {
            return;
        }
        while(slow.next != null && slow.next.next != null) {
            int move = len - 1 - slowIndex - 1;//rapid指向需要移动节点的前一个节点
            while (move != 0) {
                rapid = rapid.next;
                move--;
            }
            temp = rapid.next;
            rapid.next = temp.next;
            temp.next = slow.next;
            slow.next = temp;

            slow = slow.next.next;
            rapid = slow;
            slowIndex += 2;
        }
        show(head);
    }

    public static void show(ListNode head) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        ListNode temp = head;
        while (temp.next != null) {
            System.out.printf("%d->", temp.val);
            temp = temp.next;
        }
        System.out.printf("%d", temp.val);
        System.out.println();
    }
}

class LinkedList {

    ListNode head = new ListNode(-1);
    public ListNode createLinkedList(int len) {

        ListNode temp = null;
        for (int i = 1; i <= len; i++) {
            if (i == 1) {
                head.next = new ListNode(i);
                temp = head.next;
                continue;
            }
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        return head.next;
    }

    public int getLength() {
        if (head == null) {
            System.out.println("链表为空");
            return 0;
        }
        ListNode temp = head;
        int len = 0;
        while (temp.next != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
