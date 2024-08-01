public class DoublyLinkedList {
    class Node {
        int data;
        Node next;
        Node prev;

            Node(int data) {
                this.data = data;
                this.next = null;
                this.prev = null;
            }
    }
    public static Node head = null;

    public void addAt(int index, int data) {
        Node newNode = new Node(data);
        Node currNode = head;
        int count = 0;

         if(head == null && index != 0) {
            System.out.println("Cannot be added to particular index");
            return;
        }

        if(index > listLength()) {
            System.out.println("index out of bound");
            return;
        }

        while(count != index-1) {
            currNode = currNode.next;
            count++;
        }

        newNode.next = currNode.next;
        newNode.prev = currNode;
        newNode.next.prev = newNode;
        currNode.next = newNode;
    }

    public int listLength() {
        Node curNode = head;
        int length = 0;
        while(curNode != null) {
            length++;
            curNode = curNode.next;
        }

        return length;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        Node currNode = head;

        while(currNode.next != null) {
            currNode = currNode.next;
        }

        currNode.next = newNode;
        newNode.prev = currNode;
    }

    public void printList() {
        Node currNode = head;

        System.out.print("null <=> ");
        while(currNode != null) {
            System.out.print(currNode.data + " <=> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    public void removeFirst() {
        if(head == null) {
            System.out.println("List is empty no elements to remove.");
            return;
        }

        head = head.next;
    }

    public void removeLast() {
        if(head == null) {
            System.out.println("List is empty no elements to remove.");
            return;
        }

        Node curNode = head;
        while(curNode.next.next != null) {
            curNode = curNode.next;
        }
        curNode.next = null;
    }

    public void reverse() {
        if(head == null) {
            return;
        }

       Node curNode = head;
       Node temp = null;

       while(curNode != null) {
        temp = curNode.prev;
        curNode.prev = curNode.next;
        curNode.next = temp;

        curNode = curNode.prev;
       }

        head = temp.prev;
    }


    public static void main(String[] args) {
        DoublyLinkedList dl = new DoublyLinkedList();
        dl.addFirst(1);
        dl.addFirst(0);
        dl.addLast(2);
        dl.reverse();
        dl.printList();
    }
}
