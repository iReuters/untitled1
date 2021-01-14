package com.company;

public class JosephuCircle {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        josephu(list.createCircleLinkedList(100), 6);

    }

    public static void josephu(DoubleNode node, int n) {
        if (node == null) {
            System.out.println("链表为空");
            return;
        }
        DoubleNode temp = node;
        int flower = 1;//击鼓传花的花
        int x = 0;//记录是否到了只剩一个节点
        while (true) {
            temp = temp.next;
            flower++;
            if (flower == n) {
                if (x == temp.no) {
                    return;
                }
                x = temp.no;
                System.out.println(x);
                temp.pre.next = temp.next;
                temp.next.pre = temp.pre;
                flower = 0;
            }
        }
    }

}

class DoubleNode{
    int no;
    String name;
    DoubleNode next;
    DoubleNode pre;

    public DoubleNode(int no) {
        this.no = no;
    }

    public DoubleNode(int no, String name) {
        this.no = no;
        this.name = name;
    }
}

class DoubleLinkedList{
    private final DoubleNode head = new DoubleNode(0);

    public DoubleNode add(int n) {
        DoubleNode node = new DoubleNode(n);
        if (head.next == null) {
            head.next = node;
            node.pre = head;
            return head.next;
        }
        DoubleNode temp = head.next;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
        return temp.next;
    }

    public DoubleNode getHead() {
        return head;
    }

    public DoubleNode createCircleLinkedList(int num) {
        DoubleNode last = null;
        for (int i = 1; i <= num; i++) {
            last = add(i);
        }
        if (last == null) {
            return null;
        }
        last.next = head.next;
        head.next.pre = last;
        return head.next;
    }

    public void delete(int n) {
        if (head.next == null) {
            System.out.println("列表为空");
            return;
        }
        DoubleNode temp = head.next;
        while (temp != null) {
            if (temp.no == n) {
                break;
            }
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("未找到该节点");
        } else {
            if (temp.next == null) {
                temp.pre.next = null;
                temp.pre = null;
            } else {
                temp.pre.next = temp.next;
                temp.next.pre = temp.pre;
            }
        }
    }

    public void show() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        DoubleNode temp = head.next;
        while (temp != null) {
            System.out.println(temp.no);
            temp = temp.next;
        }
    }
}
