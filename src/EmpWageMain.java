import java.util.Random;
public class EmpWageMain {
    public static final int FULL_TIME = 1;
    public static final int PART_TIME = 2;
    public static final int WAGE_PER_HOUR = 20;
    public static final int FULL_DAY_HOUR = 8;
    public static final int PART_TIME_HOUR = 8;

    public static int checkAttendance() {
        Random rand = new Random();
        int empCheck = rand.nextInt(2);  // 0 or 1
        System.out.println("Employee is: " + (empCheck == 1 ? "Present" : "Absent"));
        return empCheck;
    }
    public static int computeDailyWage() {
        int empCheck = checkAttendance();
        int dailyWage = (empCheck == 1) ? WAGE_PER_HOUR * FULL_DAY_HOUR : 0;

        System.out.println("Daily Wage: " + dailyWage);
        return dailyWage;
    }
    public static int computePartTimeWage() {
        Random rand = new Random();
        int empCheck = rand.nextInt(3);  // 0,1,2

        int hours = 0;

        if (empCheck == FULL_TIME) {
            hours = FULL_DAY_HOUR;
        } else if (empCheck == PART_TIME) {
            hours = PART_TIME_HOUR;
        }

        int wage = WAGE_PER_HOUR * hours;
        System.out.println("Wage with Full-time/Part-time: " + wage);

        return wage;
    }
    public static int computeWageUsingSwitch() {
        Random rand = new Random();
        int empCheck = rand.nextInt(3);  // 0,1,2

        int hours = 0;

        switch (empCheck) {
            case FULL_TIME:
                hours = FULL_DAY_HOUR;
                break;

            case PART_TIME:
                hours = PART_TIME_HOUR;
                break;

            default:
                hours = 0;
        }

        int wage = WAGE_PER_HOUR * hours;
        System.out.println("Wage using Switch: " + wage);

        return wage;
    }
    public static int computeWageForMonth() {
        int totalWage = 0;

        for (int day = 1; day <= 20; day++) {
            int wage = computeWageUsingSwitch();
            totalWage += wage;
        }

        System.out.println("Monthly Wage (20 Days): " + totalWage);
        return totalWage;
    }

    public static int computeWageTillCondition() {

        int totalHours = 0;
        int totalDays = 0;
        int totalWage = 0;

        while (totalHours <= 100 && totalDays < 20) {

            Random rand = new Random();
            int empCheck = rand.nextInt(3);

            int hours = 0;

            switch (empCheck) {
                case FULL_TIME:
                    hours = FULL_DAY_HOUR;
                    break;

                case PART_TIME:
                    hours = PART_TIME_HOUR;
                    break;

                default:
                    hours = 0;
            }

            totalHours += hours;
            totalWage += hours * WAGE_PER_HOUR;
            totalDays++;
        }

        System.out.println("Total Wage (100Hrs or 20 Days): " + totalWage);
        return totalWage;
    }


    public static void main(String[] args) {
        computeDailyWage();
        computePartTimeWage();
        computeWageUsingSwitch();
        computeWageForMonth();
        computeWageTillCondition();
    }


}
