/**
 * MotorPHEmployeeSystem.java
 *
 * In this code, we create a simple payroll system for Motor PH, calculating hours worked by employees in a week 
 * and automatically calculating the pay based on the hours worked.
 * Added government deductions including SSS, PhilHealth, Pag-IBIG, and Withholding Tax.
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
                emp.calculateDeductions(); // Calculate government deductions
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
        System.out.printf("%-8s %-25s %-10s %-10s %-12s %-12s\n", 
                "ID", "Name", "Hours", "Rate (₱)", "Gross (₱)", "Net (₱)");
        System.out.println("------------------------------------------------------------------------");
        
        for (Employee emp : employees) {
            if (emp != null) {
                System.out.printf("%-8d %-25s %-10.2f %-10.2f %-12.2f %-12.2f\n", 
                        emp.getEmployeeId(), 
                        emp.getLastName() + ", " + emp.getFirstName(), 
                        emp.getTotalHoursWorked(),
                        emp.getHourlyRate(),
                        emp.getWeeklySalary(),
                        emp.getNetSalary());
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
        System.out.println("  GROSS WEEKLY SALARY: ₱" + String.format("%.2f", sampleEmployee.getWeeklySalary()));
        
        System.out.println("\nMonthly Government Deductions Calculation:");
        System.out.println("  Monthly Salary: ₱" + String.format("%.2f", sampleEmployee.getMonthlySalary()));
        System.out.println("  SSS Contribution: ₱" + String.format("%.2f", sampleEmployee.getMonthlySSS()));
        System.out.println("  PhilHealth Contribution: ₱" + String.format("%.2f", sampleEmployee.getMonthlyPhilHealth()));
        System.out.println("  Pag-IBIG Contribution: ₱" + String.format("%.2f", sampleEmployee.getMonthlyPagibig()));
        System.out.println("  Total Deductions: ₱" + String.format("%.2f", sampleEmployee.getTotalMonthlyDeductions()));
        System.out.println("  Taxable Income: ₱" + String.format("%.2f", sampleEmployee.getTaxableIncome()));
        System.out.println("  Withholding Tax: ₱" + String.format("%.2f", sampleEmployee.getMonthlyTax()));
        
        System.out.println("\nWeekly Government Deductions:");
        System.out.println("  SSS Contribution: ₱" + String.format("%.2f", sampleEmployee.getWeeklySSS()));
        System.out.println("  PhilHealth Contribution: ₱" + String.format("%.2f", sampleEmployee.getWeeklyPhilHealth()));
        System.out.println("  Pag-IBIG Contribution: ₱" + String.format("%.2f", sampleEmployee.getWeeklyPagibig()));
        System.out.println("  Withholding Tax: ₱" + String.format("%.2f", sampleEmployee.getWeeklyTax()));
        System.out.println("  Total Deductions: ₱" + String.format("%.2f", sampleEmployee.getTotalDeductions()));
        System.out.println("------------------------------------------------------------------------");
        System.out.println("  NET WEEKLY SALARY: ₱" + String.format("%.2f", sampleEmployee.getNetSalary()));
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
    
    // Government deduction properties
    private double monthlySSS;          // Monthly SSS contribution
    private double monthlyPhilHealth;   // Monthly PhilHealth contribution
    private double monthlyPagibig;      // Monthly Pag-IBIG contribution
    private double totalMonthlyDeductions; // Total monthly deductions before tax
    private double taxableIncome;       // Taxable income after deductions
    private double monthlyTax;          // Monthly withholding tax
    
    private double weeklySSS;           // Weekly SSS contribution
    private double weeklyPhilHealth;    // Weekly PhilHealth contribution
    private double weeklyPagibig;       // Weekly Pag-IBIG contribution
    private double weeklyTax;           // Weekly withholding tax
    private double totalDeductions;     // Total weekly deductions
    private double netSalary;           // Net weekly salary after deductions
    
    // Standard work week constants
    private static final double STANDARD_WEEKLY_HOURS = 40.0;
    private static final double OVERTIME_RATE_MULTIPLIER = 1.5;
    private static final double STANDARD_MONTHLY_HOURS = 160.0; // 40 hours × 4 weeks
    private static final double WEEKS_PER_MONTH = 4.33;        // Average weeks per month
    
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
     * Calculate government deductions based on monthly salary
     */
    public void calculateDeductions() {
        // Calculate monthly SSS contribution (using the provided SSS contribution table)
        calculateSSSContribution();
        
        // Calculate monthly PhilHealth contribution (using the provided PhilHealth rates)
        calculatePhilHealthContribution();
        
        // Calculate monthly Pag-IBIG contribution (using the provided Pag-IBIG rates)
        calculatePagibigContribution();
        
        // Calculate total monthly deductions (before tax)
        totalMonthlyDeductions = monthlySSS + monthlyPhilHealth + monthlyPagibig;
        
        // Calculate taxable income
        taxableIncome = monthlySalary - totalMonthlyDeductions;
        
        // Calculate monthly withholding tax
        calculateWithholdingTax();
        
        // Convert monthly deductions to weekly
        weeklySSS = monthlySSS / WEEKS_PER_MONTH;
        weeklyPhilHealth = monthlyPhilHealth / WEEKS_PER_MONTH;
        weeklyPagibig = monthlyPagibig / WEEKS_PER_MONTH;
        weeklyTax = monthlyTax / WEEKS_PER_MONTH;
        
        // Calculate total deductions and net salary
        totalDeductions = weeklySSS + weeklyPhilHealth + weeklyPagibig + weeklyTax;
        netSalary = weeklySalary - totalDeductions;
    }
    
private void calculateSSSContribution() {
    // Calculate the salary range bracket (0-500, 500-1000, etc.)
    int bracket = (int)(monthlySalary / 500);
    
    // Handle the special case for salaries below 3250
    if (monthlySalary < 3250) {
        monthlySSS = 135.00;
        return;
    }
    
    // Adjust bracket to account for the starting point of 3250
    bracket = bracket - 6;  // 3250/500 = 6.5, so start at bracket 6
    
    // Cap the bracket at the maximum salary range
    if (bracket > 43) {
        bracket = 43;  // Maximum bracket for salaries 24,750 and above
    }
    
    // Use switch case to determine SSS contribution
    switch (bracket) {
        case 0:  // 3250-3749
            monthlySSS = 157.50;
            break;
        case 1:  // 3750-4249
            monthlySSS = 180.00;
            break;
        case 2:  // 4250-4749
            monthlySSS = 202.50;
            break;
        case 3:  // 4750-5249
            monthlySSS = 225.00;
            break;
        case 4:  // 5250-5749
            monthlySSS = 247.50;
            break;
        case 5:  // 5750-6249
            monthlySSS = 270.00;
            break;
        case 6:  // 6250-6749
            monthlySSS = 292.50;
            break;
        case 7:  // 6750-7249
            monthlySSS = 315.00;
            break;
        case 8:  // 7250-7749
            monthlySSS = 337.50;
            break;
        case 9:  // 7750-8249
            monthlySSS = 360.00;
            break;
        case 10: // 8250-8749
            monthlySSS = 382.50;
            break;
        case 11: // 8750-9249
            monthlySSS = 405.00;
            break;
        case 12: // 9250-9749
            monthlySSS = 427.50;
            break;
        case 13: // 9750-10249
            monthlySSS = 450.00;
            break;
        case 14: // 10250-10749
            monthlySSS = 472.50;
            break;
        case 15: // 10750-11249
            monthlySSS = 495.00;
            break;
        case 16: // 11250-11749
            monthlySSS = 517.50;
            break;
        case 17: // 11750-12249
            monthlySSS = 540.00;
            break;
        case 18: // 12250-12749
            monthlySSS = 562.50;
            break;
        case 19: // 12750-13249
            monthlySSS = 585.00;
            break;
        case 20: // 13250-13749
            monthlySSS = 607.50;
            break;
        case 21: // 13750-14249
            monthlySSS = 630.00;
            break;
        case 22: // 14250-14749
            monthlySSS = 652.50;
            break;
        case 23: // 14750-15249
            monthlySSS = 675.00;
            break;
        case 24: // 15250-15749
            monthlySSS = 697.50;
            break;
        case 25: // 15750-16249
            monthlySSS = 720.00;
            break;
        case 26: // 16250-16749
            monthlySSS = 742.50;
            break;
        case 27: // 16750-17249
            monthlySSS = 765.00;
            break;
        case 28: // 17250-17749
            monthlySSS = 787.50;
            break;
        case 29: // 17750-18249
            monthlySSS = 810.00;
            break;
        case 30: // 18250-18749
            monthlySSS = 832.50;
            break;
        case 31: // 18750-19249
            monthlySSS = 855.00;
            break;
        case 32: // 19250-19749
            monthlySSS = 877.50;
            break;
        case 33: // 19750-20249
            monthlySSS = 900.00;
            break;
        case 34: // 20250-20749
            monthlySSS = 922.50;
            break;
        case 35: // 20750-21249
            monthlySSS = 945.00;
            break;
        case 36: // 21250-21749
            monthlySSS = 967.50;
            break;
        case 37: // 21750-22249
            monthlySSS = 990.00;
            break;
        case 38: // 22250-22749
            monthlySSS = 1012.50;
            break;
        case 39: // 22750-23249
            monthlySSS = 1035.00;
            break;
        case 40: // 23250-23749
            monthlySSS = 1057.50;
            break;
        case 41: // 23750-24249
            monthlySSS = 1080.00;
            break;
        case 42: // 24250-24749
            monthlySSS = 1102.50;
            break;
        default: // 24750 and above
            monthlySSS = 1125.00;
    }
}

    /**
     * Calculate PhilHealth contribution based on monthly salary
     * Using the provided 3% rate with equal sharing between employer and employee
     */
    private void calculatePhilHealthContribution() {
        // 3% total rate with 50% paid by employee (1.5%)
        if (monthlySalary <= 10000) {
            // For salaries at 10,000 or below (fixed amount)
            monthlyPhilHealth = 300.00 / 2; // 150.00 (employee share)
        } else if (monthlySalary < 60000) {
            // For salaries between 10,000.01 and 59,999.99
            monthlyPhilHealth = (monthlySalary * 0.03) / 2; // 1.5% of monthly salary
        } else {
            // For salaries 60,000 and above (fixed amount)
            monthlyPhilHealth = 1800.00 / 2; // 900.00 (employee share)
        }
    }
    
    /**
     * Calculate Pag-IBIG contribution based on monthly salary
     * Using the provided Pag-IBIG contribution table
     */
    private void calculatePagibigContribution() {
        if (monthlySalary <= 1500) {
            // 1% employee contribution for salaries up to 1,500
            monthlyPagibig = monthlySalary * 0.01;
        } else {
            // 2% employee contribution for salaries over 1,500
            monthlyPagibig = monthlySalary * 0.02;
            
            // Cap at 100 pesos as per standard Pag-IBIG rule
            if (monthlyPagibig > 100) {
                monthlyPagibig = 100;
            }
        }
    }
    
    /**
     * Calculate withholding tax based on monthly salary after deductions
     * Using the provided withholding tax table
     */
    private void calculateWithholdingTax() {
        // Already calculated taxable income = monthlySalary - totalMonthlyDeductions
        
        if (taxableIncome <= 20832) {
            // No withholding tax for income up to 20,832
            monthlyTax = 0;
        } else if (taxableIncome < 33333) {
            // 20% of the excess over 20,833
            monthlyTax = (taxableIncome - 20833) * 0.20;
        } else if (taxableIncome < 66667) {
            // 2,500 plus 25% of the excess over 33,333
            monthlyTax = 2500 + ((taxableIncome - 33333) * 0.25);
        } else if (taxableIncome < 166667) {
            // 10,833 plus 30% of the excess over 66,667
            monthlyTax = 10833 + ((taxableIncome - 66667) * 0.30);
        } else if (taxableIncome < 666667) {
            // 40,833.33 plus 32% of the excess over 166,667
            monthlyTax = 40833.33 + ((taxableIncome - 166667) * 0.32);
        } else {
            // 200,833.33 plus 35% of the excess over 666,667
            monthlyTax = 200833.33 + ((taxableIncome - 666667) * 0.35);
        }
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
    
    // Getters for salary calculations
    public double getTotalHoursWorked() {
        return totalHoursWorked;
    }
    
    public double getRegularPay() {
        return regularPay;
    }
    
    public double getOvertimePay() {
        return overtimePay;
    }
    
    public double getWeeklySalary() {
        return weeklySalary;
    }
    
    // Getters for monthly deductions
    public double getMonthlySSS() {
        return monthlySSS;
    }
    
    public double getMonthlyPhilHealth() {
        return monthlyPhilHealth;
    }
    
    public double getMonthlyPagibig() {
        return monthlyPagibig;
    }
    
    public double getTotalMonthlyDeductions() {
        return totalMonthlyDeductions;
    }
    
    public double getTaxableIncome() {
        return taxableIncome;
    }
    
    public double getMonthlyTax() {
        return monthlyTax;
    }
    
    // Getters for weekly deductions
    public double getWeeklySSS() {
        return weeklySSS;
    }
    
    public double getWeeklyPhilHealth() {
        return weeklyPhilHealth;
    }
    
    public double getWeeklyPagibig() {
        return weeklyPagibig;
    }
    
    public double getWeeklyTax() {
        return weeklyTax;
    }
    
    public double getTotalDeductions() {
        return totalDeductions;
    }
    
    public double getNetSalary() {
        return netSalary;
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