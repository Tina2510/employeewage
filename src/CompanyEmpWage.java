public class CompanyEmpWage {
    public final String company;
    public final int empRatePerHour;
    public final int workingDays;
    public final int maxHours;
    public int totalWage;

    public CompanyEmpWage(String company, int empRatePerHour, int workingDays, int maxHours) {
        this.company = company;
        this.empRatePerHour = empRatePerHour;
        this.workingDays = workingDays;
        this.maxHours = maxHours;
    }

    public void setTotalWage(int totalWage) {
        this.totalWage = totalWage;
    }
}
