public class CircularQueues {
    public static class CircularQueue {
        int arr[];
        int rear = -1;
        int front = -1;
        int size = 0;

        CircularQueue(int size) {
            this.arr = new int[size];
            this.size = size;
        } 

        public void add(int data) {
            if(front == -1) {
                front++;
                rear++;
                arr[front] = data;
                return;
            }
            if((rear+1) % size != front) {
                rear = (rear+1) % size;
                arr[rear] = data;
                return;
            } 

            System.out.println("Queue is full");
            return;
        }

        public int remove() {
            if(front+1 == rear) {
                System.out.println("Queue if full");
                return -1;
            }
            int frontEle = arr[front];
            arr[front] = 0;
            front++;
            return frontEle;
        }
        
        public void printList() {
            for(int i=front; i<=i%size; i++) {
                System.out.println(arr[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);
        cq.add(1);
        cq.add(2);
        cq.add(3);
        cq.add(4);
        cq.add(5);
        cq.remove();
        cq.printList();
    }
    
}
