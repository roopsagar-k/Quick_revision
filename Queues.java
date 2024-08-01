public class Queues {
    static class Queue {
        int size;
        int arr[];
        int rear = -1;

        Queue(int size) {
            this.size = size;
            this.arr = new int[size];
        }

        //enqueue
        public void add(int data) {
            if(rear == size-1) {
                System.out.println("Queue is full");
                return;
            }

            rear++;
            arr[rear] = data;
        }

        //dequeue
        public int remove() {
            if(rear == -1) {
                System.out.println("Queue is empty");
                return rear;
            }

            int front = arr[0];
            for(int i=0; i<=rear; i++) {
                arr[i] = arr[i+1];
            }
            rear--;
            return front;
        }

        //peek
        public int peek() {
            if(rear == -1) {
                System.out.println("Queue is empty");
                return rear;
            }

            return arr[0];
        }

        public void printQueue() {
            for(int i=0; i<=rear; i++) {
                System.out.print(arr[i] + " ");
            }
        }

    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(0);
        q.add(1);
        q.add(2);
        q.add(3);
        q.printQueue();
        q.remove();
        System.out.println("Peek : " + q.peek());
        q.printQueue();
        
    }
}
