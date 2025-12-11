import java.util.ArrayList;

public class CompanyEmpWage {

    public final String companyName;
    public final int wagePerHour;
    public final int workingDays;
    public final int maxHours;

    public int totalWage;


    public ArrayList<Integer> dailyWageList;

    public CompanyEmpWage(String companyName, int wagePerHour, int workingDays, int maxHours) {
        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.workingDays = workingDays;
        this.maxHours = maxHours;
        this.dailyWageList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return companyName + " : Total Wage = " + totalWage + ", Daily Wages = " + dailyWageList;
    }
}
