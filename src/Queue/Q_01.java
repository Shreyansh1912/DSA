package Queue;

class buildNormalQueue {
    public static class CustomQueue {
        int[] data;
        int front;
        int size;

        public CustomQueue(int cap) {
            data = new int[cap];
            front = 0;
            size = 0;
        }

        int size() {
            return size;
        }

        void display() {
            for (int i = 0; i < size; i++) {
                int index = (front + i) % data.length;
                System.out.print(data[index] + " ");
            }
            System.out.println();
        }

        void add(int val) {
            if (size == data.length) {
                System.out.println("QUEUE OVERFLOW");
            } else {
                int rear = (front + size) % data.length;
                data[rear] = val;
                size++;
            }
        }

        int remove() {
            if (size == 0) {
                System.out.println("QUEUE UNDERFLOW");
                return -1;
            } else {
                int val = data[front];
                front = (front + 1) % data.length;
                size--;
                return val;
            }
        }

        int peek() {
            if (size == 0) {
                System.out.println("QUEUE UNDERFLOW");
                return -1;
            } else {
                return data[front];
            }
        }
    }

    public static void main(String[] args) {
        CustomQueue cq = new CustomQueue(5);
        cq.peek();
        cq.remove();
        System.out.println(cq.size());
        cq.add(1);
        cq.peek();
        cq.display();
        cq.add(2);
        System.out.println(cq.size());
        cq.peek();
        cq.display();
        cq.add(3);
        cq.peek();
        cq.display();
        cq.add(4);
        cq.peek();
        System.out.println(cq.size());
        cq.display();
        cq.add(5);
        cq.peek();
        System.out.println(cq.size());
        cq.display();
        System.out.println(cq.remove());
        System.out.println(cq.remove());
        System.out.println(cq.remove());
        System.out.println(cq.remove());
        System.out.println(cq.remove());
        System.out.println(cq.remove());
        System.out.println(cq.remove());
        System.out.println(cq.size());
    }
}