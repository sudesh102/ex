import java.util.Scanner;
import pack.Arithmatic;
import pack.Statistical;
import pack.Trigonometric;

public class Switch_case_Operation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Choose an operation:");
            System.out.println("1. Arithmetic Operations");
            System.out.println("2. Statistical Operations");
            System.out.println("3. Trigonometric Operations");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nArithmetic Operations:");
                    System.out.print("Enter the first number: ");
                    float num1 = scanner.nextFloat();
                    System.out.print("Enter the second number: ");
                    float num2 = scanner.nextFloat();

                    System.out.println("Addition: " + Arithmatic.add(num1, num2));
                    System.out.println("Subtraction: " + Arithmatic.sub(num1, num2));
                    System.out.println("Multiplication: " + Arithmatic.mul(num1, num2));

                    if (num2 != 0) {
                        System.out.println("Division: " + Arithmatic.div(num1, num2));
                    } else {
                        System.out.println("Division: Cannot divide by zero");
                    }
                    break;

                case 2:
                    System.out.println("\nStatistical Operations:");
                    System.out.print("Enter the number of elements in the array: ");
                    int n = scanner.nextInt();
                    double[] arr = new double[n];
                    System.out.println("Enter the elements:");
                    for (int i = 0; i < n; i++) {
                        arr[i] = scanner.nextDouble();
                    }

                    double mean = Statistical.mean(arr);
                    if (mean == -1) {
                        System.out.println("Array is empty, cannot compute mean.");
                    } else {
                        System.out.println("Mean: " + mean);
                    }
                    break;

                case 3:
                    System.out.println("\nTrigonometric Operations:");
                    System.out.print("Enter an angle in degrees: ");
                    double angle = scanner.nextDouble();

                    System.out.println("Sine of " + angle + " degrees: " + Trigonometric.sine(angle));
                    System.out.println("Cosine of " + angle + " degrees: " + Trigonometric.cosine(angle));
                    System.out.println("Tangent of " + angle + " degrees: " + Trigonometric.tangent(angle));
                    break;

                case 4:
                    // Exit
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                    break;
            }

            System.out.println(); // Add a blank line for readability

        } while (choice != 4);

        scanner.close();
    }
}
