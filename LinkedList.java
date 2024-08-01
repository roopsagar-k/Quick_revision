public class LinkedList {
    class Node {
        int data;
        Node next;
         Node(int data) {
            this.data = data;
            this.next = null;
         }
    }

    public Node head = null;

    //remove first Node from the list
    public void removeFirst(){
        if(head == null) {
            System.out.println("No Nodes to delete");
            return;
        }
        head = head.next;
    }

    //remove the last Node form the list
    public void removeLast() {
        if(head == null) {
            System.out.println("No Nodes to delete");
            return;
        }
        Node secondLast = head;
        Node last = head.next;

        while(last.next != null){
            last = last.next;
            secondLast = secondLast.next;
        }
        
        secondLast.next = null;
    }

    //add at the particular index
    public void addAt(int data, int index) {
        Node newNode = new Node(data);
        int length = getLength();
        if(head == null && index != 0) {
            System.out.println("Cannot be added to particular index");
            return;
        }
        if(index+1 > length) {
            System.out.println("Cannot be added to particular index");
            return;
        }

        Node currNode = head;
        int currIndex = 0;
        while(currIndex != index-1) {
            currNode = currNode.next;
            currIndex++;
        }

        newNode.next = currNode.next;
        currNode.next = newNode;

    }

    //add a node at the end of the list 
    public void addLast(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }
        Node currNode = head;
        while(currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
        newNode.next = null;
    }


    //add a node at beginning of the list
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    //Get length of the ll
    public int getLength() {
        Node currNode = head;
        int length = 0;
        while(currNode != null) {
            length++;
            currNode = currNode.next;
        }
        return length;
    }

    public void reverseList() {
        Node prevNode = head;
        Node currNode = head.next;
        Node nextNode = head.next.next;

        prevNode.next = null;
       while(nextNode != null) {
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
            nextNode = nextNode.next;
       }
       currNode.next = prevNode;
       head = currNode;
    }

    //print the linkedList
    public void printList() {
        Node currNode = head;
        while(currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(0);
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);

        System.out.println("Before reverse : ");
        ll.printList();

        ll.reverseList();

        System.out.println("After reverse : ");
        ll.printList();
    }
}