import java.util.Scanner;

public class ex3 {
    public static class Employe{
		String firstName;
		String lastName;
		double salary;
		Employe(){
			firstName="";
			lastName="";
			salary=0.0;
		}
		Employe(String firstName,String lastName,double salary){
			this.firstName=firstName;
			this.lastName=lastName;
			this.salary=salary;
		}
		public String getFirstName(){
			return firstName;
		}
		public String getLastName(){
			return lastName;
		}
		public double getSalary(){
			return salary;
		}
        public double getRaiseSal(){
            return salary+(salary*10)/100;
        }	
	};
	
	public static void main(String[] args){
		String firstName,lastName;
		double salary,raise;
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the info of 1st emp");
		System.out.println("Enter First name:");
		firstName=in.next();
		System.out.println("Enter Last name:");
		lastName=in.next();
		System.out.println("Enter salary per month:");
		salary=in.nextDouble();
		
		Employe e1=new Employe(firstName,lastName,salary);
		System.out.println("First name="+e1.getFirstName()+"\n"+"Last name="+e1.getLastName()+"\n"+"Salary="+e1.getSalary());
		System.out.println("Yearly salary="+e1.getSalary()*12);
		raise=e1.getSalary();
		raise=raise+(raise*10)/100;
		System.out.println("After raise of 10% in salary="+raise);
		System.out.println("After raise of 10% in salary="+e1.getRaiseSal());

		System.out.println("Enter the info of 2nd emp");
		System.out.println("Enter First name:");
		firstName=in.next();
		System.out.println("Enter Last name:");
		lastName=in.next();
		System.out.println("Enter salary per month:");
		salary=in.nextDouble();
		
		Employe e2=new Employe(firstName,lastName,salary);
		System.out.println("First name="+e2.getFirstName()+"\n"+"Last name="+e2.getLastName()+"\n"+"Salary="+e2.getSalary());
		System.out.println("Yearly salary="+e2.getSalary()*12);
		raise=e2.getSalary();
		raise=raise+(raise*10)/100;
		System.out.println("After raise of 10% in salary="+raise);
	}
}
/* 
import java.util.Scanner;

public class EmployeeManagement {
    public static class Employee {
        String firstName;
        String lastName;
        double salary;

        Employee() {
            firstName = "";
            lastName = "";
            salary = 0.0;
        }

        Employee(String firstName, String lastName, double salary) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.salary = salary;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public double getSalary() {
            return salary;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public double calculateYearlySalary() {
            return salary * 12;
        }

        public void applyRaise(double percentage) {
            salary += (salary * percentage) / 100;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee[] employees = new Employee[100]; // Array to store employee details
        int count = 0; // Counter for the number of employees
        int choice;

        do {
            System.out.println("\n*** Employee Management Menu ***");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employee Details");
            System.out.println("3. Calculate Yearly Salary");
            System.out.println("4. Apply Salary Raise");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: // Add Employee
                    if (count >= employees.length) {
                        System.out.println("Employee storage full. Cannot add more employees.");
                        break;
                    }
                    System.out.print("Enter First Name: ");
                    String firstName = sc.next();
                    System.out.print("Enter Last Name: ");
                    String lastName = sc.next();
                    System.out.print("Enter Monthly Salary: ");
                    double salary = sc.nextDouble();
                    employees[count] = new Employee(firstName, lastName, salary);
                    count++;
                    System.out.println("Employee added successfully.");
                    break;

                case 2: // Display Employee Details
                    if (count == 0) {
                        System.out.println("No employees to display.");
                    } else {
                        System.out.println("\nEmployee Details:");
                        for (int i = 0; i < count; i++) {
                            Employee e = employees[i];
                            System.out.println("Employee " + (i + 1) + ": ");
                            System.out.println("First Name: " + e.getFirstName());
                            System.out.println("Last Name: " + e.getLastName());
                            System.out.println("Monthly Salary: " + e.getSalary());
                        }
                    }
                    break;

                case 3: // Calculate Yearly Salary
                    if (count == 0) {
                        System.out.println("No employees to calculate yearly salary for.");
                    } else {
                        System.out.println("\nYearly Salaries:");
                        for (int i = 0; i < count; i++) {
                            Employee e = employees[i];
                            System.out.println("Employee " + (i + 1) + " Yearly Salary: " + e.calculateYearlySalary());
                        }
                    }
                    break;

                case 4: // Apply Salary Raise
                    if (count == 0) {
                        System.out.println("No employees to apply a salary raise to.");
                    } else {
                        System.out.print("Enter Raise Percentage: ");
                        double percentage = sc.nextDouble();
                        for (int i = 0; i < count; i++) {
                            employees[i].applyRaise(percentage);
                        }
                        System.out.println("Salary raise applied successfully.");
                    }
                    break;

                case 5: // Exit
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}

*/