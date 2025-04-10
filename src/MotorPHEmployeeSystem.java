/**
 * MotorPHEmployeeSystem.java
 * 
 * This program displays basic employee information in the prescribed format:
 * employee number, employee name, birthday.
 */

public class MotorPHEmployeeSystem {
    public static void main(String[] args) {
        // Create employee database array with test data
        Employee[] employees = initializeEmployeeDatabase();
        
        // Display header
        System.out.println("========================================================================");
        System.out.println("                         MOTOR PH PAYROLL SYSTEM                        ");
        System.out.println("========================================================================");
        
        // Display all employees in the prescribed format
        displayAllEmployees(employees);
    }
    
    /**
     * Initializes the employee database with test data
     * @return Array of Employee objects with test data
     */
    private static Employee[] initializeEmployeeDatabase() {
        Employee[] employees = new Employee[13];
        
        // Initialize with data from the provided database
        employees[0] = new Employee(10001, "Garcia", "Manuel III", "10/11/1983", 90000);
        employees[1] = new Employee(10002, "Lim", "Antonio", "06/19/1988", 60000);
        employees[2] = new Employee(10003, "Aquino", "Bianca Sofia", "08/04/1989", 60000);
        employees[3] = new Employee(10004, "Reyes", "Isabella", "06/16/1994", 60000);
        employees[4] = new Employee(10005, "Hernandez", "Eduard", "09/23/1989", 52670);
        employees[5] = new Employee(10006, "Villanueva", "Andrea Mae", "02/14/1988", 52670);
        employees[6] = new Employee(10007, "San Jose", "Brad", "03/15/1996", 42975);
        employees[7] = new Employee(10008, "Romualdez", "Alice", "05/14/1992", 22500);
        employees[8] = new Employee(10009, "Atienza", "Rosie", "09/24/1948", 22500);
        employees[9] = new Employee(10010, "Alvaro", "Roderick", "03/30/1988", 52670);
        employees[10] = new Employee(10032, "Castro", "John Rafael", "02/09/1992", 52670);
        employees[11] = new Employee(10033, "Martinez", "Carlos Ian", "11/16/1990", 52670);
        employees[12] = new Employee(10021, "Lazaro", "Darlene", "11/25/1985", 23250);
        
        return employees;
    }
    
    /**
     * Displays all employees in the prescribed format: employee number, employee name, birthday
     * @param employees Array of Employee objects to display
     */
    private static void displayAllEmployees(Employee[] employees) {
        for (Employee emp : employees) {
            if (emp != null) {
                System.out.println("Employee Number: " + emp.getEmployeeId());
                System.out.println("Employee Name: " + emp.getLastName() + ", " + emp.getFirstName());
                System.out.println("Birthday: " + emp.getBirthday());
                System.out.println("------------------------------------------------------------------------");
            }
        }
    }
}

/**
 * Employee class to represent basic employee information
 */
class Employee {
    private int employeeId;
    private String lastName;
    private String firstName;
    private String birthday;
    private double monthlySalary;
    
    /**
     * Constructor for Employee class with basic information
     */
    public Employee(int employeeId, String lastName, String firstName, String birthday, double monthlySalary) {
        this.employeeId = employeeId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.monthlySalary = monthlySalary;
    }
    
    // Getters for basic employee information
    public int getEmployeeId() {
        return employeeId;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getBirthday() {
        return birthday;
    }
    
    public double getMonthlySalary() {
        return monthlySalary;
    }
}