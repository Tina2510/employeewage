public interface IComputeEmpWage {
    void addCompany(String name, int wagePerHour, int workingDays, int maxHours);
    void computeWages();
    int getTotalWage(String companyName);
}
