public class StackUsingLinkedList {
    static class Stack {
        class Node {
            int data;
            Node next;
            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        public static Node head = null;

        public void push(int data) {
            Node newNode = new Node(data);

            if(head == null) {
                head = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;
        }

        public int pop() {
            if(head == null) {
                System.out.println("Stack is empty");
                return -1;
            }

            int top = head.data;
            head = head.next;
            return top;
        }

        public int peek() {
            if(head == null) {
                System.out.println("Stack is empty");
                return -1;
            }

            return head.data;
        }

        public void printStack() {
            Node curNode = head;
            while (curNode != null) {
                System.out.println(curNode.data);
                curNode = curNode.next;
            }
        }
        
    }

    public static void main(String[] args) {
        Stack s1 = new Stack();
        s1.push(0);
        s1.push(1);
        s1.push(2);
        s1.push(100);
        s1.push(200);
        System.out.println("Stackelements");
        s1.printStack();
        System.out.println("Poped element: " + s1.pop());
        System.out.println("Peek : " + s1.peek());
        s1.printStack();
    }
}
