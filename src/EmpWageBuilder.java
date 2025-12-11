import java.util.Random;
public class EmpWageBuilder {
    private final int FULL_TIME = 1;
    private final int PART_TIME = 2;
    private final int WAGE_PER_HOUR = 20;
    private final int FULL_DAY_HOUR = 8;
    private final int PART_TIME_HOUR = 8;
    private final int MAX_DAYS = 20;
    private final int MAX_HOURS = 100;

    private Random rand;


    public EmpWageBuilder() {
        rand = new Random();
    }
    public int computeDailyWage() {
        int empCheck = rand.nextInt(2); // 0 or 1
        int wage = (empCheck == 1) ? FULL_DAY_HOUR * WAGE_PER_HOUR : 0;
        System.out.println("UC7 → Daily Wage = " + wage);
        return wage;
    }


    public int computePartTimeWage() {
        int empCheck = rand.nextInt(3); // 0,1,2
        int hours = (empCheck == FULL_TIME) ? FULL_DAY_HOUR :
                (empCheck == PART_TIME) ? PART_TIME_HOUR : 0;
        int wage = hours * WAGE_PER_HOUR;
        System.out.println("UC7 → Part-Time/Full-Time Wage = " + wage);
        return wage;
    }
    public int computeWageUsingSwitch() {
        int empCheck = rand.nextInt(3);
        int hours = 0;

        switch(empCheck) {
            case FULL_TIME: hours = FULL_DAY_HOUR; break;
            case PART_TIME: hours = PART_TIME_HOUR; break;
            default: hours = 0;
        }

        int wage = hours * WAGE_PER_HOUR;
        System.out.println("UC7 → Wage using Switch = " + wage);
        return wage;
    }

    public int computeWageForMonth() {
        int totalWage = 0;
        for(int day=1; day<=MAX_DAYS; day++){
            totalWage += computeWageUsingSwitch();
        }
        System.out.println("UC7 → Total Wage for Month = " + totalWage);
        return totalWage;
    }

    public int computeWageTillCondition() {
        int totalHours = 0, totalDays = 0, totalWage = 0;
        while(totalHours < MAX_HOURS && totalDays < MAX_DAYS){
            int empCheck = rand.nextInt(3);
            int hours = 0;
            switch(empCheck){
                case FULL_TIME: hours = FULL_DAY_HOUR; break;
                case PART_TIME: hours = PART_TIME_HOUR; break;
                default: hours = 0;
            }
            totalHours += hours;
            totalWage += hours * WAGE_PER_HOUR;
            totalDays++;
        }
        System.out.println("UC7 → Total Wage till Condition = " + totalWage);
        return totalWage;
    }

    public static void main(String[] args){
        EmpWageBuilder emp = new EmpWageBuilder();
        emp.computeDailyWage();
        emp.computePartTimeWage();
        emp.computeWageUsingSwitch();
        emp.computeWageForMonth();
        emp.computeWageTillCondition();
    }
}
