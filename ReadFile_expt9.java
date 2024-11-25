import java.io.*;
import java.util.Scanner;

public class ReadFile_expt9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the file name: ");
        String fileName = sc.nextLine();

        while (true) {
            System.out.println("\nFile Operations Menu:");
            System.out.println("1. Read from file");
            System.out.println("2. Write to file");
            System.out.println("3. Append to file");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");
            int choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                    readFile(fileName);
                    break;
                case 2:
                    System.out.print("Enter data to write: ");
                    String dataToWrite = sc.nextLine();
                    writeFile(fileName, dataToWrite);
                    break;
                case 3:
                    System.out.print("Enter data to append: ");
                    String dataToAppend = sc.nextLine();
                    appendToFile(fileName, dataToAppend);
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void readFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("File Content:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void writeFile(String fileName, String data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write(data);
            System.out.println("Data written to file.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void appendToFile(String fileName, String data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName,true))) {
            bw.write(data);
            System.out.println("Data appended to file.");
        } catch (IOException e) {
            System.out.println("Error appending to file: " + e.getMessage());
        }
    }
}
