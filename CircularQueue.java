import java.util.Scanner;

public class CircularQueue {
    static final int CAPACITY = 10;
    static String[] queue = new String[CAPACITY];
    static int front = -1;
    static int rear = -1;

    public static boolean isFull() {
        return (rear + 1) % CAPACITY == front;
    }

    public static boolean isEmpty() {
        return front == -1;
    }

    public static void enqueue(String print) {
        if (isFull()) {
            System.out.println("Queue Full");
            return;
        }
        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % CAPACITY;
        queue[rear] = print;
        System.out.println("Enqueued: " + print);
    }

    public static String dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return null;
        }
        String job = queue[front];
        System.out.println("Dequeued: " + job);

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % CAPACITY;
        }
        return job;
    }

    public static void displayFront() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
        } else {
            System.out.println("Front element: " + queue[front]);
        }
    }

    public static void displayRear() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
        } else {
            System.out.println("Rear element: " + queue[rear]);
        }
    }

    public static void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return;
        }
        System.out.print("Current Queue: ");
        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear) break;
            i = (i + 1) % CAPACITY;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nPrinter");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display Front");
            System.out.println("4. Display Rear");
            System.out.println("5. Display Queue");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumes the trailing newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter document: ");
                    String jobName = scanner.nextLine();
                    enqueue(jobName);
                    break;
                case 2:
                    dequeue();
                    break;
                case 3:
                    displayFront();
                    break;
                case 4:
                    displayRear();
                    break;
                case 5:
                    displayQueue();
                    break;
                case 6:
                    System.out.println("Exitin");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}