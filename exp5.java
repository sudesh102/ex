import java.util.Scanner;

class Person {
    public  String name;
    public  String birthdate;
    public  double height;
    public  double weight;
    public  String address;

    public Person(String name, String birthdate, double height, double weight, String address) {
        this.name = name;
        this.birthdate = birthdate;
        this.height = height;
        this.weight = weight;
        this.address = address;
    }

    public double calculate() {
        return weight / (height * height);
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Birthdate: " + birthdate);
        System.out.println("Height: " + height + " meters");
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Address: " + address);
    }
}

class Student extends Person {
    public  int rollNo;
    public  double[] marks;

    public Student(String name, String birthdate, double height, double weight, String address, int rollNo, double[] marks) {
        super(name, birthdate, height, weight, address);
        this.rollNo = rollNo;
        this.marks = marks;
    }

    public double calculateAvg() {
        double sum = 0;
        for (double mark : marks) {
            sum += mark;
        }
        return sum / marks.length;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Roll No: " + rollNo);
        System.out.println("Average Marks: " + calculateAvg());
    }
}

class Employee extends Person {
    public  int empId;
    public  double salary;

    public Employee(String name, String birthdate, double height, double weight, String address, int empId, double salary) {
        super(name, birthdate, height, weight, address);
        this.empId = empId;
        this.salary = salary;
    }

    public double calculateTax() {
        return salary * 0.20;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Employee ID: " + empId);
        System.out.println("Salary: " + salary);
        System.out.println("Calculated Tax: " + calculateTax());
    }
}

public class exp5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Enter Student Details");
            System.out.println("2. Enter Employee Details");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String studentName = sc.nextLine();
                    System.out.print("Enter Birthdate (YYYY-MM-DD): ");
                    String studentBirthdate = sc.nextLine();
                    System.out.print("Enter Height (in meters): ");
                    double studentHeight = sc.nextDouble();
                    System.out.print("Enter Weight (in kg): ");
                    double studentWeight = sc.nextDouble();
                    sc.nextLine(); 
                    System.out.print("Enter Address: ");
                    String studentAddress = sc.nextLine();
                    System.out.print("Enter Roll Number: ");
                    int rollNo = sc.nextInt();
                    System.out.print("Enter Number of Subjects: ");
                    int numSubjects = sc.nextInt();
                    double[] marks = new double[numSubjects];
                    for (int i = 0; i < numSubjects; i++) {
                        System.out.print("Enter Marks for Subject " + (i + 1) + ": ");
                        marks[i] = sc.nextDouble();
                    }
                    Student student = new Student(studentName, studentBirthdate, studentHeight, studentWeight, studentAddress, rollNo, marks);
                    System.out.println("\nStudent Details:");
                    student.display();
                    System.out.println("BMI: " + student.calculate());
                    break;

                case 2:
                    System.out.print("Enter Name: ");
                    String empName = sc.nextLine();
                    System.out.print("Enter Birthdate (YYYY-MM-DD): ");
                    String empBirthdate = sc.nextLine();
                    System.out.print("Enter Height (in meters): ");
                    double empHeight = sc.nextDouble();
                    System.out.print("Enter Weight (in kg): ");
                    double empWeight = sc.nextDouble();
                    sc.nextLine(); 
                    System.out.print("Enter Address: ");
                    String empAddress = sc.nextLine();
                    System.out.print("Enter Employee ID: ");
                    int empId = sc.nextInt();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    Employee employee = new Employee(empName, empBirthdate, empHeight, empWeight, empAddress, empId, salary);
                    System.out.println("\nEmployee Details:");
                    employee.display();
                    System.out.println("BMI: " + employee.calculate());
                    break;

                case 3:
                    System.out.println("Exiting Program. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
