public class Employee {
    private String name;
    private int age;
    private String designation;
    private double salary;

    // Constructor
    public Employee(String name, int age, String designation, double salary) {
        this.name = name;
        this.age = age;
        this.designation = designation;
        this.salary = salary;
    }

    // Getters
    public String getName() {
        return name;
    }
    //Setters
    public void setName(String name) {
        this.name = name;
    }
    //Getters
    public int getAge() {
        return age;
    }
    //Setters
    public void setAge(int age) {
        this.age = age;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // toString method to display employee details
    @Override
    public String toString() {
        return "name = ' " + name + '\'' +
                ", age = " + age +
                ", designation = '" + designation + '\'' +
                ", salary = " + salary +"\n";
    }
}
