/**
 * MotorPHEmployeeSystem.java
 *
 * In this code, we create a simple payroll system for Motor PH. calculating hours worked by employees in a week and automatically calculating the pay based on the hours worked.
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
        
        // Calculate weekly salary for all employees
        calculateWeeklySalaries(employees);
        
        // Display weekly payroll report
        displayWeeklyPayrollReport(employees);
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
                emp.addWorkDay(0, 8.0, 17.0);  // 8:00 AM to 5:00 PM
                
                // Tuesday
                emp.addWorkDay(1, 8.0, 17.5);  // 8:00 AM to 5:30 PM
                
                // Wednesday
                emp.addWorkDay(2, 8.5, 17.0);  // 8:30 AM to 5:00 PM
                
                // Thursday
                emp.addWorkDay(3, 8.0, 18.0);  // 8:00 AM to 6:00 PM
                
                // Friday
                emp.addWorkDay(4, 8.0, 17.0);  // 8:00 AM to 5:00 PM
            }
        }
    }
    
    /**
     * Calculates weekly salaries for all employees
     * @param employees Array of Employee objects
     */
    private static void calculateWeeklySalaries(Employee[] employees) {
        for (Employee emp : employees) {
            if (emp != null) {
                emp.calculateWeeklySalary();
            }
        }
    }
    
    /**
     * Displays weekly payroll report for all employees
     * @param employees Array of Employee objects to display
     */
    private static void displayWeeklyPayrollReport(Employee[] employees) {
        System.out.println("\nWEEKLY PAYROLL REPORT");
        System.out.println("========================================================================");
        System.out.printf("%-8s %-25s %-10s %-10s %-12s\n", 
                "ID", "Name", "Hours", "Rate (₱)", "Salary (₱)");
        System.out.println("------------------------------------------------------------------------");
        
        for (Employee emp : employees) {
            if (emp != null) {
                System.out.printf("%-8d %-25s %-10.2f %-10.2f %-12.2f\n", 
                        emp.getEmployeeId(), 
                        emp.getLastName() + ", " + emp.getFirstName(), 
                        emp.getTotalHoursWorked(),
                        emp.getHourlyRate(),
                        emp.getWeeklySalary());
            }
        }
        System.out.println("========================================================================");
        
        // Display detailed information for one sample employee
        Employee sampleEmployee = employees[0];
        System.out.println("\nDETAILED CALCULATION (Sample - Employee ID: " + sampleEmployee.getEmployeeId() + ")");
        System.out.println("========================================================================");
        System.out.println("Employee: " + sampleEmployee.getLastName() + ", " + sampleEmployee.getFirstName());
        System.out.println("Monthly Salary: ₱" + String.format("%.2f", sampleEmployee.getMonthlySalary()));
        System.out.println("Hourly Rate: ₱" + String.format("%.2f", sampleEmployee.getHourlyRate()));
        System.out.println("\nHours Worked:");
        System.out.println("  Monday:    " + String.format("%.2f", sampleEmployee.getDailyHours(0)));
        System.out.println("  Tuesday:   " + String.format("%.2f", sampleEmployee.getDailyHours(1)));
        System.out.println("  Wednesday: " + String.format("%.2f", sampleEmployee.getDailyHours(2)));
        System.out.println("  Thursday:  " + String.format("%.2f", sampleEmployee.getDailyHours(3)));
        System.out.println("  Friday:    " + String.format("%.2f", sampleEmployee.getDailyHours(4)));
        System.out.println("  Total:     " + String.format("%.2f", sampleEmployee.getTotalHoursWorked()) + " hours");
        System.out.println("\nSalary Calculation:");
        System.out.println("  Regular Hours: " + String.format("%.2f", Math.min(40, sampleEmployee.getTotalHoursWorked())));
        System.out.println("  Regular Pay: ₱" + String.format("%.2f", sampleEmployee.getRegularPay()));
        
        double overtimeHours = Math.max(0, sampleEmployee.getTotalHoursWorked() - 40);
        System.out.println("  Overtime Hours: " + String.format("%.2f", overtimeHours));
        System.out.println("  Overtime Pay: ₱" + String.format("%.2f", sampleEmployee.getOvertimePay()));
        System.out.println("------------------------------------------------------------------------");
        System.out.println("  TOTAL WEEKLY SALARY: ₱" + String.format("%.2f", sampleEmployee.getWeeklySalary()));
        System.out.println("========================================================================");
    }
}

/**
 * Employee class to represent employee information and weekly salary calculations
 */
class Employee {
    private int employeeId;
    private String lastName;
    private String firstName;
    private String birthday;
    private double monthlySalary;
    
    // Arrays to store time data for each work day (index 0-4 for Monday-Friday)
    private double[] clockInTimes = new double[5];
    private double[] clockOutTimes = new double[5];
    private double[] hoursPerDay = new double[5];
    private double totalHoursWorked;
    
    // Salary calculation properties
    private double hourlyRate;
    private double regularPay;    // Pay for first 40 hours
    private double overtimePay;   // Pay for hours over 40
    private double weeklySalary;  // Total weekly salary
    
    // Standard work week constants
    private static final double STANDARD_WEEKLY_HOURS = 40.0;
    private static final double OVERTIME_RATE_MULTIPLIER = 1.5;
    private static final double STANDARD_MONTHLY_HOURS = 160.0; // 40 hours × 4 weeks
    
    /**
     * Constructor for Employee class with basic information
     */
    public Employee(int employeeId, String lastName, String firstName, String birthday, double monthlySalary) {
        this.employeeId = employeeId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.monthlySalary = monthlySalary;
        
        // Calculate the hourly rate based on monthly salary
        this.hourlyRate = monthlySalary / STANDARD_MONTHLY_HOURS;
    }
    
    /**
     * Add a work day to the employee's timesheet
     * @param dayIndex Day index (0=Monday, 1=Tuesday, etc.)
     * @param clockInTime Clock in time in decimal hours (e.g., 8.5 = 8:30 AM)
     * @param clockOutTime Clock out time in decimal hours (e.g., 17.5 = 5:30 PM)
     */
    public void addWorkDay(int dayIndex, double clockInTime, double clockOutTime) {
        if (dayIndex >= 0 && dayIndex < 5) {
            clockInTimes[dayIndex] = clockInTime;
            clockOutTimes[dayIndex] = clockOutTime;
            
            // Calculate hours worked for this day
            double hoursWorked = clockOutTime - clockInTime;
            
            // Deduct 1 hour lunch break if the employee worked more than 5 hours
            if (hoursWorked > 5) {
                hoursWorked -= 1;
            }
            
            hoursPerDay[dayIndex] = hoursWorked;
        }
    }
    
    /**
     * Calculate the employee's weekly salary based on hours worked
     */
    public void calculateWeeklySalary() {
        // Reset total hours
        totalHoursWorked = 0;
        
        // Sum up hours from all work days
        for (double hours : hoursPerDay) {
            totalHoursWorked += hours;
        }
        
        // Calculate regular pay (up to standard 40 hours)
        double regularHours = Math.min(STANDARD_WEEKLY_HOURS, totalHoursWorked);
        regularPay = regularHours * hourlyRate;
        
        // Calculate overtime pay (hours beyond standard 40 hours at overtime rate)
        double overtimeHours = Math.max(0, totalHoursWorked - STANDARD_WEEKLY_HOURS);
        overtimePay = overtimeHours * hourlyRate * OVERTIME_RATE_MULTIPLIER;
        
        // Calculate total weekly salary
        weeklySalary = regularPay + overtimePay;
    }
    
    /**
     * Get hours worked for a specific day
     * @param dayIndex Day index (0=Monday, 1=Tuesday, etc.)
     * @return Hours worked for that day
     */
    public double getDailyHours(int dayIndex) {
        if (dayIndex >= 0 && dayIndex < 5) {
            return hoursPerDay[dayIndex];
        }
        return 0;
    }
    
    /**
     * Get total hours worked for the week
     * @return Total hours worked
     */
    public double getTotalHoursWorked() {
        return totalHoursWorked;
    }
    
    /**
     * Get regular pay (for standard hours)
     * @return Regular pay amount
     */
    public double getRegularPay() {
        return regularPay;
    }
    
    /**
     * Get overtime pay
     * @return Overtime pay amount
     */
    public double getOvertimePay() {
        return overtimePay;
    }
    
    /**
     * Get total weekly salary
     * @return Weekly salary amount
     */
    public double getWeeklySalary() {
        return weeklySalary;
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
    
    public double getHourlyRate() {
        return hourlyRate;
    }
}