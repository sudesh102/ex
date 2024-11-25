import java.util.*;

class Except extends Exception {
    public Except(String msg) {
        super(msg);
    }
}

class expt_8_exception {
    private float num1;
    private float num2;

    public expt_8_exception(float num1, float num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public float add() throws Except {
        float re = num1 + num2;
        if (re > 1000) {
            throw new Except("Addition above 1000!!!");
        }
        return re;
    }

    public float sub() throws Except {
        float re = num1 - num2;
        if (re < 0) {
            throw new Except("Subtraction is negative!!!");
        }
        return re;
    }

    public float div() throws Except {
        if (num2 == 0) {
            throw new Except("Division by zero not possible");
        }
        return num1 / num2;
    }

    public float mul() throws Except {
        float re = num1 * num2;
        if (re > 5000) {
            throw new Except("Multiplication is above 5000");
        }
        return re;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Addition \n2. Subtraction \n3. Multiplication \n4. Division \n5. Exit");
            System.out.print("Enter operation to perform (1-5): ");
            int ch = sc.nextInt();
            
            if (ch == 5) {
                break;
            }

            System.out.print("Enter two numbers: ");
            float num1 = sc.nextFloat();
            float num2 = sc.nextFloat();
            expt_8_exception operations = new expt_8_exception(num1, num2);

            try {
                switch (ch) {
                    case 1:
                        System.out.println("The Addition is: " + operations.add());
                        break;
                    case 2:
                        System.out.println("The Subtraction is: " + operations.sub());
                        break;
                    case 3:
                        System.out.println("The Multiplication is: " + operations.mul());
                        break;
                    case 4:
                        System.out.println("The Division is: " + operations.div());
                        break;
                    default:
                        System.out.println("Invalid operation. Please choose between 1 and 5.");
                }
            } catch (Except e) {
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}
