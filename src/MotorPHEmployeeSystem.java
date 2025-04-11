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
        
                // For demonstration, set sample weekly timesheet data
        setWeeklyTimesheet(employees);
        
        // Display all employees with hours worked
        displayEmployeesWithHoursWorked(employees);
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
     * Sets sample timesheet data for each employee for demonstration purposes
     * In a real application, this data would come from an actual timesheet system
     * @param employees Array of Employee objects
     */
    private static void setWeeklyTimesheet(Employee[] employees) {
        for (Employee emp : employees) {
            if (emp != null) {
                // Set clock-in and clock-out times for each day of the week
                // Format: hour value in 24-hour format (e.g., 8.5 = 8:30 AM, 17.75 = 5:45 PM)
                
                // Monday
                emp.setDailyTimesheet(0, 8.0, 17.0);  // 8:00 AM to 5:00 PM
                
                // Tuesday
                emp.setDailyTimesheet(1, 8.0, 17.5);  // 8:00 AM to 5:30 PM
                
                // Wednesday
                emp.setDailyTimesheet(2, 8.5, 17.0);  // 8:30 AM to 5:00 PM
                
                // Thursday
                emp.setDailyTimesheet(3, 8.0, 18.0);  // 8:00 AM to 6:00 PM
                
                // Friday
                emp.setDailyTimesheet(4, 8.0, 17.0);  // 8:00 AM to 5:00 PM
                
                // Calculate hours worked based on timesheet
                emp.calculateHoursWorked();
            }
        }
    }
    
    /**
     * Displays employees with their calculated hours worked
     * @param employees Array of Employee objects to display
     */
    private static void displayEmployeesWithHoursWorked(Employee[] employees) {
        for (Employee emp : employees) {
            if (emp != null) {
                System.out.println("Employee Number: " + emp.getEmployeeId());
                System.out.println("Employee Name: " + emp.getLastName() + ", " + emp.getFirstName());
                System.out.println("Birthday: " + emp.getBirthday());
                
                // Show daily hours
                System.out.println("Hours Worked This Week:");
                System.out.printf("  Monday: %.2f hours\n", emp.getDailyHours(0));
                System.out.printf("  Tuesday: %.2f hours\n", emp.getDailyHours(1));
                System.out.printf("  Wednesday: %.2f hours\n", emp.getDailyHours(2));
                System.out.printf("  Thursday: %.2f hours\n", emp.getDailyHours(3));
                System.out.printf("  Friday: %.2f hours\n", emp.getDailyHours(4));
                
                // Show total hours worked
                System.out.printf("Total Hours Worked: %.2f hours\n", emp.getTotalHoursWorked());
                
                System.out.println("------------------------------------------------------------------------");
            }
        }
    }
}

/**
 * Employee class to represent basic employee information and work hours
 */
class Employee {
    private int employeeId;
    private String lastName;
    private String firstName;
    private String birthday;
    private double monthlySalary;
    
    // Arrays to store clock in and clock out times for each day (index 0-4 for Monday-Friday)
    private double[] clockInTimes = new double[5];
    private double[] clockOutTimes = new double[5];
    private double[] dailyHours = new double[5];
    private double totalHoursWorked;
    
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
    
    /**
     * Set the clock in and clock out times for a specific day
     * @param dayIndex Day index (0=Monday, 1=Tuesday, etc.)
     * @param clockIn Clock in time in decimal hours (e.g., 8.5 = 8:30 AM)
     * @param clockOut Clock out time in decimal hours (e.g., 17.5 = 5:30 PM)
     */
    public void setDailyTimesheet(int dayIndex, double clockIn, double clockOut) {
        if (dayIndex >= 0 && dayIndex < 5) {
            clockInTimes[dayIndex] = clockIn;
            clockOutTimes[dayIndex] = clockOut;
        }
    }
    
    /**
     * Calculates the hours worked for each day and the total for the week
     */
    public void calculateHoursWorked() {
        totalHoursWorked = 0;
        
        for (int i = 0; i < 5; i++) {
            // Calculate hours worked for this day (clock out time - clock in time)
            // Deduct lunch break if workday is > 5 hours
            double hoursWorked = clockOutTimes[i] - clockInTimes[i];
            
            // Deduct 1 hour lunch break if the employee worked more than 5 hours
            if (hoursWorked > 5) {
                hoursWorked -= 1;
            }
            
            // Store the calculated hours for this day
            dailyHours[i] = hoursWorked;
            
            // Add to the running total
            totalHoursWorked += hoursWorked;
        }
    }
    
    /**
     * Get the hours worked for a specific day
     * @param dayIndex Day index (0=Monday, 1=Tuesday, etc.)
     * @return Hours worked for that day
     */
    public double getDailyHours(int dayIndex) {
        if (dayIndex >= 0 && dayIndex < 5) {
            return dailyHours[dayIndex];
        }
        return 0;
    }
    
    /**
     * Get the total hours worked for the week
     * @return Total hours worked
     */
    public double getTotalHoursWorked() {
        return totalHoursWorked;
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