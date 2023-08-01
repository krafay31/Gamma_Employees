

public class updateEmployee {
    public static boolean updateEmployee(String name, String newName, int newAge, String newDesignation, double newSalary) {
        Employee foundEmployee = EmployeeManagementSystem.findEmployeeByName(name);
        if (foundEmployee != null) {
            foundEmployee.setName(newName);
            foundEmployee.setAge(newAge);
            foundEmployee.setDesignation(newDesignation);
            foundEmployee.setSalary(newSalary);
            System.out.println("Employee details updated successfully.");
            return true;
        } else {
            System.out.println("Employee with name '" + name + "' not found.");
            return false;
        }
    }

}