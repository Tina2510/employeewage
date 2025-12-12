import java.util.ArrayList;

public class CompanyEmpWage {

    public String companyName;
    public int wagePerHour;
    public int workingDays;
    public int maxHours;
    public int totalWage;


    public ArrayList<Integer> dailyWageList = new ArrayList<>();

    public CompanyEmpWage(String companyName, int wagePerHour, int workingDays, int maxHours) {
        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.workingDays = workingDays;
        this.maxHours = maxHours;
    }

    @Override
    public String toString() {
        return "Company: " + companyName +
                " Total Wage: " + totalWage +
                " Daily Wages: " + dailyWageList;
    }
}
