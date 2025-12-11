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

        System.out.println("UC2 → Daily Wage: " + dailyWage);
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


}
