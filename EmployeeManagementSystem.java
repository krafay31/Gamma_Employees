import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagementSystem {
    private static List<Employee> employees;

    public EmployeeManagementSystem() {
        employees = new ArrayList<>();
    }

    // Method to add a new employee
    public void addEmployee(String name, int age, String designation, double salary) {
        Employee newEmployee = new Employee(name, age, designation, salary);
        employees.add(newEmployee);
        System.out.println("Employee added successfully!");
    }

    // Method to display all employees
    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("List of Employees:");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

   // To Search for Employee
   public void searchEmployee(String name) {
       String trimmedName = name.trim(); // Trim the input name to remove leading/trailing spaces
       boolean found = false;
       for (Employee employee : employees) {
           if (employee.getName().equalsIgnoreCase(trimmedName)) {
               System.out.println("Employee found:");
               System.out.println(employee);
               found = true;
               break;
           }
       }
       if (!found) {
           System.out.println("Employee with name '" + trimmedName + "' not found.");
       }
   }
    public static Employee findEmployeeByName(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(name)) {
                return employee;
            }
        }
        return null;
    }
    //To Delete an employee

    public void deleteEmployee(String name) {
        boolean found = false;
        Employee foundEmployee = null;

        for (Employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(name)) {
                foundEmployee = employee;
                found = true;
                break;
            }
        }

        if (found) {
            employees.remove(foundEmployee);
            System.out.println("Employee with name '" + name + "' deleted successfully.");
        } else {
            System.out.println("Employee with name '" + name + "' not found.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManagementSystem empManagementSystem = new EmployeeManagementSystem();

        boolean continueLoop = true;
        while (continueLoop) {
            System.out.println("Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Search Employee ");
            System.out.println("4. Edit Employee ");
            System.out.println("5. Delete an Employee From the Data.");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
            } catch (Exception e) {
                scanner.nextLine(); // Consume the invalid input
                System.out.println("Invalid choice. Please enter a valid option.");
                System.out.println("Press Enter key to continue...");
                scanner.nextLine(); // Wait for the Enter key to be pressed
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter employee age: ");
                    int age;
                    try {
                        age = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                    } catch (Exception e) {
                        scanner.nextLine(); // Consume the invalid input
                        System.out.println("Invalid age. Please enter a valid age.");
                        System.out.println("Press Enter key to continue...");
                        scanner.nextLine(); // Wait for the Enter key to be pressed
                        continue;
                    }
                    System.out.print("Enter employee designation: ");
                    String designation = scanner.nextLine();
                    System.out.print("Enter employee salary: ");
                    double salary;
                    try {
                        salary = scanner.nextDouble();
                        scanner.nextLine(); // Consume the newline character
                    } catch (Exception e) {
                        scanner.nextLine(); // Consume the invalid input
                        System.out.println("Invalid salary. Please enter a valid salary.");
                        System.out.println("Press Enter key to continue...");
                        scanner.nextLine(); // Wait for the Enter key to be pressed
                        continue;
                    }
                    empManagementSystem.addEmployee(name, age, designation, salary);
                    break;
                case 2:
                    empManagementSystem.displayEmployees();
                    break;
                case 3:
                    System.out.print("Enter employee name to search: ");
                    String searchName = scanner.nextLine();
                    empManagementSystem.searchEmployee(searchName);
                    break;
                case 4:
                    System.out.print("Enter employee name to update: ");
                    String nameToUpdate = scanner.nextLine();
                    System.out.print("Enter new employee name: ");
                    String newName = scanner.nextLine();

                    // Initialize newAge and newSalary to default
                    int newAge = 0;
                    double newSalary = 0.0;

                    System.out.print("Enter new employee age: ");
                    try {
                        newAge = Integer.parseInt(scanner.nextLine());
                        //for newAge
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid age. Please enter a valid age.");
                        break;
                    }

                    System.out.print("Enter new employee designation: ");
                    String newDesignation = scanner.nextLine();

                    System.out.print("Enter new employee salary: ");
                    try {
                        newSalary = Double.parseDouble(scanner.nextLine());
                        //for newSalary
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid salary. Please enter a valid salary.");
                        break;
                    }

                    boolean isUpdated = updateEmployee.updateEmployee(nameToUpdate, newName, newAge, newDesignation, newSalary);
                    if (!isUpdated) {
                        System.out.println("Employee with name '" + nameToUpdate + "' not found.");
                    }
                    break;
                case 5:
                    System.out.print("Employee name you want delete : ");
                    String nameToDelete = scanner.nextLine();
                    empManagementSystem.deleteEmployee(nameToDelete);
                    break;
                case 6:
                    System.out.println("Exiting the Employee Management System."+'\n'+"Thank You!");
                    scanner.close();
                    continueLoop = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    System.out.println("Press Enter key to continue...");
                    scanner.nextLine(); // Wait for the Enter key to be pressed
            }

            System.out.println();

            System.out.println("Press Enter key to continue...");
            scanner.nextLine(); // Wait for the Enter key to be pressed
            System.out.println();
        }
    }
}
