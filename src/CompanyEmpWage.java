public class CompanyEmpWage {
    public final String companyName;
    public final int wagePerHour;
    public final int workingDays;
    public final int maxHours;
    public int totalWage;

    public CompanyEmpWage(String companyName, int wagePerHour, int workingDays, int maxHours) {
        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.workingDays = workingDays;
        this.maxHours = maxHours;
        this.totalWage = 0;
    }

    public void setTotalWage(int totalWage) {
        this.totalWage = totalWage;
    }

    @Override
    public String toString() {
        return "Company: " + companyName + ", Total Wage: " + totalWage;
    }
}
