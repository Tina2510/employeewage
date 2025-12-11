import java.util.Random;

public class EmpWageBuilder {

    private final int FULL_TIME = 1;
    private final int PART_TIME = 2;

    private Random rand;


    public EmpWageBuilder() {
        rand = new Random();
    }

    private int getWorkingHours(int empCheck, int fullDayHour, int partTimeHour) {
        switch (empCheck) {
            case FULL_TIME:
                return fullDayHour;
            case PART_TIME:
                return partTimeHour;
            default:
                return 0;
        }
    }

    public void computeWageForCompany(String company, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {

        int totalHours = 0;
        int totalDays = 0;
        int totalWage = 0;

        while (totalHours < maxWorkingHours && totalDays < maxWorkingDays) {

            int empCheck = rand.nextInt(3);
            int hoursWorked = getWorkingHours(empCheck, 8, 8);
            totalHours += hoursWorked;
            totalWage += hoursWorked * wagePerHour;
            totalDays++;
        }

        System.out.println("Company: " + company + "  Total Wage = " + totalWage);
    }


    public static void main(String[] args) {
        EmpWageBuilder empWage = new EmpWageBuilder();


        empWage.computeWageForCompany("TCS", 20, 20, 100);
        empWage.computeWageForCompany("Infosys", 25, 22, 120);
        empWage.computeWageForCompany("Wipro", 30, 18, 90);
    }
}
