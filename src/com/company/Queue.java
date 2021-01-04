package com.company;

public class Queue {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addByOrder(2, "宋江");
        linkedList.addByOrder(4, "卢俊义");
        linkedList.addByOrder(3, "吴用");
        linkedList.addByOrder(1, "吴a");
        linkedList.show();
        System.out.println();


    }
}

class Node {
    int no;
    String name;
    Node next;

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }
}

class LinkedList {
    private Node head = new Node(0, "");

    public void add(int no, String name) {
        Node temp = head.next;
        if (temp == null){
            head.next = new Node(no, name);
            return;
        }


        while (true) {
            if (temp.next != null) {
                temp = temp.next;
            }
            else {
                break;
            }
        }
        temp.next = new Node(no, name);
    }

    /**
     * 链表反转
     * @return 反转后链表头节点
     */

    public Node reverse() {
        Node newHead = new Node(0, "");
        Node temp = head.next;
        Node temp1 = newHead.next;
        if (temp == null) {
            return null;
        }
        while (true) {
            if (temp.next== null) {
                return temp;
            }
            temp = temp.next;
        }

        while (true) {
            Node node = lastNode();
            if (node != null) {

            }
        }
        return null;
    }

    public Node lastNode() {
        Node temp = head.next;
        if (temp == null) {
            return null;
        }

    }

    public void addByOrder(int no, String name) {
        Node temp = head.next;
        if (temp == null){
            head.next = new Node(no, name);
            return;
        }
        if (no <= 0 ) {
            System.out.println("序号输入错误");
            return;
        }
        while (true) {
            if (temp.next == null){
                temp.next = new Node(no, name);
                return;
            }else if (no == temp.next.no) {
                System.out.printf("%s已经存在\n", name);
                return;
            }else if (no < temp.no) {
                Node node = new Node(no, name);
                node.next = temp;
                head.next = node;
                return;
            }
             else if (no < temp.next.no) {
                Node node = new Node(no, name);
                node.next = temp.next;
                temp.next = node;
                return;
            }
            temp = temp.next;
        }
    }

    public Node lastIndexNode(int k) {
        int len = lenth();
        if (k <=0 || k > len) {
            System.out.println("序号输入错误");
            return null;
        }
        Node temp = head.next;
        for (int i = 0; i < len - k; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public int lenth() {
        int count = 0;
        Node temp = head.next;
        while (temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void show() {
        Node temp = head.next;
        while (temp != null) {
            System.out.println(temp.no + " " + temp.name);
            temp = temp.next;
        }
    }

}
