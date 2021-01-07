package com.company;

public class Queue {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
//        linkedList.addByOrder(2, "宋江");
//        linkedList.addByOrder(4, "卢俊义");
//        linkedList.addByOrder(3, "吴用");
//        linkedList.addByOrder(1, "吴a");
//        linkedList.show();
//        System.out.println("反转后");
//        linkedList.reverse();
        Node l1 = new Node(9, "");
        //l1.next = new Node(3, "");
        Node l2 = new Node(9, "");
        l2.next = new Node(9, "");
        Node n = linkedList.addTwoNumbers(l1, l2);
        show(n);

    }
    public static void show(Node head) {
        Node temp = head.next;
        while (temp != null) {
            System.out.println(temp.no + " " + temp.name);
            temp = temp.next;
        }
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

    public Node addTwoNumbers(Node l1, Node l2) {
        Node head = new Node(0, "");
        Node t1 = l1;
        Node t2 = l2;
        int addOne = 0;
        while (true) {
            int add = ((t1.no + t2.no) % 10 + addOne) % 10;
            int a = ((t1.no + t2.no) % 10 + addOne) / 10;
            Node num = new Node(add, "");
            addNumber(num, head);
            addOne = (t1.no + t2.no) / 10 + a;
            if (t1.next == null && t2.next == null) {
                break;
            }
            if (t1.next != null) {
                t1 = t1.next;
            }else {
                t1.no = 0;
            }
            if (t2.next != null) {
                t2 = t2.next;
            } else {
                t2.no = 0;
            }

        }

        if (addOne == 1) {
            addNumber(new Node(addOne, ""), head);
        }
        return head;
    }

    private void addNumber(Node node, Node head) {
        Node temp = head.next;
        if (temp == null){
            head.next = node;
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
        temp.next = node;
    }


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

    public void reverse() {
        Node temp = head.next;
        Node newHead = new Node(0, "");
        Node temp1 = null;
        if (temp == null) {
            return;
        }
        while (true) {
            Node node = new Node(temp.no, temp.name);
            node.next = temp1;
            newHead.next = node;
            temp1 = newHead.next;
            if (temp.next != null) {
                temp = temp.next;
                head.next = temp;
            }
            else {
                showByHead(newHead);
                return;
            }

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

    private void showByHead(Node head) {
        if (head == null) {
            System.out.println("空链表");
            return;
        }
        Node temp = head.next;
        while (temp != null) {
            System.out.println(temp.no + " " + temp.name);
            temp = temp.next;
        }
    }

}
