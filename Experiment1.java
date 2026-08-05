import java.util.Scanner;

class Experiment1 {
    static int top = -1;
    static String a[] = new String[5];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println();
            System.out.println(" Browser History Stack ");
            System.out.println("1. Push");
            System.out.println("2. Pop ");
            System.out.println("3. Peek ");
            System.out.println("4. Display ");
            System.out.println("5. Check if stack is empty");
            System.out.println("6. Check if stack is full");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter URL to visit: ");
                    String url = sc.next();
                    push(url);
                    break;
                case 2:
                    pop();
                    break;
                case 3:
                    peek();
                    break;
                case 4:
                    dispay();
                    break;
                case 5:
                    isempty();
                    break;
                case 6:
                    isfull();
                    break;
                case 7:
                    System.out.println("Exit");
                    break;
            }
        } while (choice != 7);
    }

    static void push(String x) {
        top = top + 1;
        a[top] = x;
        System.out.println("Pushing element " + x + " in the stack \n");
    }

    static void pop() {
        System.out.println("Popping topmost element: " + a[top] + " \n");
        top -= 1;
    }

    static void peek() {
        System.out.println("Displaying top element \n");
        System.out.println(a[top]);
    }

    static void dispay() {
        System.out.println("Displaying all the elements\n");
        for (int i = top; i >= 0; i--) {
            System.out.println(a[i]);
        }
    }

    static void isempty() {
        if (top == -1)
            System.out.println("Stack is empty.\n");
        else
            System.out.println("Stack is NOT empty.\n");
    }

    static void isfull() {
        if (top == a.length - 1)
            System.out.println("Stack is full.\n");
        else
            System.out.println("Stack is NOT full.\n");
    }
}