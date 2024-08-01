public class Stacks {
    static class Stack {
        int size;
        int arr[];
        int top = -1;

        Stack(int size) {
            this.size = size;
            this.arr = new int[size];
        }

        public void push(int data) {
            if(top+1 == size) {
                System.out.println("Stack is full!");
                return;
            }
            top++;
            arr[top] = data;
        }

        public int pop() {
            if(top == -1) {
                System.out.println("Stack is empty!");
                return -1;
            }

            int pop = arr[top];
            arr[top] = 0;
            top--;
            return pop;
        }

        public int peek() {
            if(top == -1) {
                System.out.println("stack is empty");
                return top;
            }

            return arr[top];
        }

        

        public void printStack() {
            for(int i=top; i>=0; i--) {
                System.out.println(arr[i]);
            }
        }

    }

    public static void main(String[] args) {
        Stack s = new Stack(4);
        Stack s1 = new Stack(5);

        s1.push(0);
        s1.push(1);
        s1.push(2);
        s1.push(100);
        s1.printStack();
        System.out.println("Peek : " + s1.peek());
    }
}
