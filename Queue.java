import java.util.Scanner;

public class Queue {
    static int front = -1;
    static int rear = -1;
    static int CAPACITY = 10;
    static String[] arr = new String[CAPACITY];
    
    public void enqueue(String item) {
        if (rear == CAPACITY - 1) {
            System.out.println("queue Overflow");
            return;
        }
        if (front == -1 && rear == -1) {
            front = 0;
        }
        rear++;
        arr[rear] = item;
        System.out.println("Enqueued: " + item);
    }

    public String dequeue() {
        if (front == -1 || front > rear) {
            System.out.println("queue underflow") ;
            return null;
        }
        String item = arr[front];
        front++;
        return item;
    }

    public String peek() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty");
            return null;
        }
        return arr[front];
    }

    public void display() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Current Queue: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + (i < rear ? ", " : ""));
        }
        System.out.println();
    }

    public void displayFront() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty!");
        } else {
            System.out.println("Front element (Next to be served): " + arr[front]);
        }
    }    

    public void displayRear() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty!");
        } else {
            System.out.println("Rear element (Last joined): " + arr[rear]);
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n Railway Ticket Counter Queue ");
            System.out.println("1. Enqueue ");
            System.out.println("2. Dequeue ");
            System.out.println("3. Display");
            System.out.println("4. Display Front");
            System.out.println("5. Display Rear");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name to enqueue: ");
                    String item = scanner.nextLine();
                    q.enqueue(item);
                    break;
                case 2:
                    String dequeued = q.dequeue();
                    if (dequeued != null) {
                        System.out.println("Served/Dequeued: " + dequeued);
                    }
                    break;
                case 3:
                    q.display();
                    break;
                case 4:
                    q.displayFront();
                    break;
                case 5:
                    q.displayRear();
                    break;
                case 6:
                    System.out.println("Exiting program. Thank you!");
                    break;
                default:
                    System.out.println("Please choose a valid option between 1 and 6.");
            }
        } while (choice != 6);
        
        scanner.close();
    }
}