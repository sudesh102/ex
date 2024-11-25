import java.io.*;
import java.util.*;
public class Stu_Info_expt10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "";
        while (true) {
            System.out.println("1. To enter the student info.\n2. To retrieve student info.\n3. Stop ");
            int ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1:
                    System.out.println("Enter file name:");
                    fileName = sc.nextLine();
                    System.out.println("Enter PRN:");
                    String PRN = sc.nextLine();
                    System.out.println("Enter Class:");
                    String className = sc.nextLine();
                    System.out.println("Enter Age:");
                    int age = sc.nextInt();
                    System.out.println("Enter Weight (in kg):");
                    float wt = sc.nextFloat();
                    System.out.println("Enter Height (in ft):");
                    float ht = sc.nextFloat();
                    sc.nextLine();
                    System.out.println("Enter City:");
                    String city = sc.nextLine();
                    System.out.println("Enter Phone:");
                    String ph = sc.nextLine();
                    try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
                        dos.writeUTF(PRN);
                        dos.writeUTF(className);
                        dos.writeInt(age);
                        dos.writeFloat(wt);
                        dos.writeFloat(ht);
                        dos.writeUTF(city);
                        dos.writeUTF(ph);
                    } catch (IOException e) {
                        System.out.println("Error writing to file: " + e.getMessage());
                    }
                    break;

                case 2:
                    if (fileName.isEmpty()) {
                        System.out.println("No file is specified. Please enter file data first");
                        break;
                    }
                    try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
                        String prn = dis.readUTF();
                        String classname = dis.readUTF();
                        int ageRead = dis.readInt();
                        float wtRead = dis.readFloat();
                        float htRead = dis.readFloat();
                        String cityRead = dis.readUTF();
                        String phRead = dis.readUTF();
                        System.out.println("PRN No: " + prn);
                        System.out.println("Class: " + classname);
                        System.out.println("Age: " + ageRead);
                        System.out.println("Weight: " + wtRead);
                        System.out.println("Height: " + htRead);
                        System.out.println("City: " + cityRead);
                        System.out.println("Phone: " + phRead);
                    } catch (IOException e) {
                        System.out.println("Error reading from file: " + e.getMessage());
                    }
                    break;
                    
                case 3:
                    sc.close();
                    return;

                default:
                    System.out.println("Enter a valid choice");
            }
        }
    }
}



/*  import java.io.*;
import java.util.Scanner;

public class Stu_Info_expt10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "";

        while (true) {
            System.out.println("\n1. Add Student Info");
            System.out.println("2. Retrieve Student Info");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter file name to save data: ");
                    fileName = sc.nextLine();
                    addStudentInfo(sc, fileName);
                    break;

                case 2:
                    if (fileName.isEmpty()) {
                        System.out.println("No file specified. Please add data first.");
                    } else {
                        displayStudentInfo(fileName);
                    }
                    break;

                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

     /**
    // Adds student information and saves it to a file.
    
    private static void addStudentInfo(Scanner sc, String fileName) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            System.out.print("Enter PRN: ");
            String PRN = sc.nextLine();
            dos.writeUTF(PRN);

            System.out.print("Enter Class: ");
            String className = sc.nextLine();
            dos.writeUTF(className);

            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            dos.writeInt(age);

            System.out.print("Enter Weight (in kg): ");
            float weight = sc.nextFloat();
            dos.writeFloat(weight);

            System.out.print("Enter Height (in ft): ");
            float height = sc.nextFloat();
            dos.writeFloat(height);

            sc.nextLine(); // Consume the newline character

            System.out.print("Enter City: ");
            String city = sc.nextLine();
            dos.writeUTF(city);

            System.out.print("Enter Phone: ");
            String phone = sc.nextLine();
            dos.writeUTF(phone);

            System.out.println("Student information added successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    
     // Reads and displays student information from a file.
     
    private static void displayStudentInfo(String fileName) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            System.out.println("\nStudent Information:");

            String PRN = dis.readUTF();
            String className = dis.readUTF();
            int age = dis.readInt();
            float weight = dis.readFloat();
            float height = dis.readFloat();
            String city = dis.readUTF();
            String phone = dis.readUTF();

            System.out.println("PRN: " + PRN);
            System.out.println("Class: " + className);
            System.out.println("Age: " + age);
            System.out.println("Weight: " + weight + " kg");
            System.out.println("Height: " + height + " ft");
            System.out.println("City: " + city);
            System.out.println("Phone: " + phone);
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please ensure the file exists.");
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}

*/