import java.util.Scanner;

interface Inter_stack {
    void push(int data);
    int pop();
    int peek();
    void display_st();
}

interface Inter_queue {
    void enqueue(int data);
    int dequeue();
    void display_qu();
}

class stack_op implements Inter_stack {
    private int[] stArr;
    private int top;
    private int capacity;

    // Constructor
    public stack_op(int capacity) {
        this.capacity = capacity;
        stArr = new int[capacity];
        top = -1;
    }

    @Override
    public void push(int data) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow! Cannot push.");
        } else {
            stArr[++top] = data;
            System.out.println("Pushed " + data + " to stack.");
        }
    }

    @Override
    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow! No element to pop.");
            return -1;
        } else {
            return stArr[top--];
        }
    }

    @Override
    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return -1;
        } else {
            return stArr[top];
        }
    }

    @Override
    public void display_st() {
        if (top == -1) {
            System.out.println("Stack is empty!");
        } else {
            System.out.print("Stack elements: ");
            for (int i = top; i >= 0; i--) {
                System.out.print(stArr[i] + " ");
            }
            System.out.println();
        }
    }
}

// Implement Queue Operations
class queue_op implements Inter_queue {
    private int[] quArr;
    private int front, rear;
    private int capacity;

    // Constructor
    public queue_op(int capacity) {
        this.capacity = capacity;
        quArr = new int[capacity];
        front = 0;
        rear = -1;
    }

    @Override
    public void enqueue(int data) {
        if (rear == capacity - 1) {
            System.out.println("Queue Overflow! Cannot enqueue.");
        } else {
            quArr[++rear] = data;
            System.out.println("Enqueued " + data + " to queue.");
        }
    }

    @Override
    public int dequeue() {
        if (front > rear) {
            System.out.println("Queue Underflow! No element to dequeue.");
            return -1;
        } else {
            return quArr[front++];
        }
    }

    @Override
    public void display_qu() {
        if (front > rear) {
            System.out.println("Queue is empty!");
        } else {
            System.out.print("Queue elements: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(quArr[i] + " ");
            }
            System.out.println();
        }
    }
}

// Main Class with Menus
public class interface_st_qu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initializing stack and queue with user-defined capacity
        System.out.print("Enter the capacity for Stack and Queue: ");
        int capacity = sc.nextInt();
        stack_op stack = new stack_op(capacity);
        queue_op queue = new queue_op(capacity);

        int choice;

        do {
            System.out.println("\nMain Menu:");
            System.out.println("1. Stack Operations");
            System.out.println("2. Queue Operations");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: // Stack Operations Menu
                    int stackChoice;
                    do {
                        System.out.println("\nStack Menu:");
                        System.out.println("1. Push");
                        System.out.println("2. Pop");
                        System.out.println("3. Peek");
                        System.out.println("4. Display");
                        System.out.println("0. Back to Main Menu");
                        System.out.print("Enter your choice: ");
                        stackChoice = sc.nextInt();

                        switch (stackChoice) {
                            case 1:
                                System.out.print("Enter element to push: ");
                                int stackElement = sc.nextInt();
                                stack.push(stackElement);
                                break;
                            case 2:
                                int poppedElement = stack.pop();
                                if (poppedElement != -1) {
                                    System.out.println("Popped element: " + poppedElement);
                                }
                                break;
                            case 3:
                                int peekElement = stack.peek();
                                if (peekElement != -1) {
                                    System.out.println("Top element: " + peekElement);
                                }
                                break;
                            case 4:
                                stack.display_st();
                                break;
                            case 0:
                                System.out.println("Returning to Main Menu...");
                                break;
                            default:
                                System.out.println("Invalid choice! Try again.");
                        }
                    } while (stackChoice != 0);
                    break;

                case 2: // Queue Operations Menu
                    int queueChoice;
                    do {
                        System.out.println("\nQueue Menu:");
                        System.out.println("1. Enqueue");
                        System.out.println("2. Dequeue");
                        System.out.println("3. Display");
                        System.out.println("0. Back to Main Menu");
                        System.out.print("Enter your choice: ");
                        queueChoice = sc.nextInt();

                        switch (queueChoice) {
                            case 1:
                                System.out.print("Enter element to enqueue: ");
                                int queueElement = sc.nextInt();
                                queue.enqueue(queueElement);
                                break;
                            case 2:
                                int dequeuedElement = queue.dequeue();
                                if (dequeuedElement != -1) {
                                    System.out.println("Dequeued element: " + dequeuedElement);
                                }
                                break;
                            case 3:
                                queue.display_qu();
                                break;
                            case 0:
                                System.out.println("Returning to Main Menu...");
                                break;
                            default:
                                System.out.println("Invalid choice! Try again.");
                        }
                    } while (queueChoice != 0);
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 0);

        sc.close();
    }
}
