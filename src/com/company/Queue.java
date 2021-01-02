package com.company;

public class Queue {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        System.out.println(linkedList.isEmpty());
        linkedList.add(1, "宋江");
        linkedList.add(2, "卢俊义");
        linkedList.add(3, "吴用");
        linkedList.add(4, "林冲");
        linkedList.show();
        linkedList.delete("宋江");
        linkedList.show();

    }
}

class Node {
    int n;
    String name;
    Node next;

    public Node(int n, String name) {
        this.n = n;
        this.name = name;
    }
}

class LinkedList {
    private Node dummy = new Node(0, "");
    private Node head;

    public boolean isEmpty() {
        return dummy.next == null;
    }

    public void add(int n, String name) {
        Node node = new Node(n, name);
        if (isEmpty()) {
            dummy.next = node;
            return;
        }
        traverse().next = node;


    }

    public void delete(String name) {
        head = dummy;
        if (isEmpty()) {
            return;
        }
        while (head != null) {
            if (head.next.name.equals(name)) {
                break;
            }
            head = head.next;
        }
        head.next = head.next.next;
    }

    public Node research(String name) {
        head = dummy.next;
        if (isEmpty()) {
            return null;
        }
        while (head != null) {
            if (head.name.equals(name)) {
                return head;
            }
            head = head.next;
        }
        System.out.println("未找到该节点");
        return null;
    }

    private Node traverse() {
        head = dummy.next;
        if (isEmpty()) {
            return null;
        }
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }

    public void show() {
        head = dummy.next;
        while (head != null) {
            System.out.println(head.n + " " + head.name);
            head = head.next;
        }
    }

}
