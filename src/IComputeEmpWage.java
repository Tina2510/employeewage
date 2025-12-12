public interface IComputeEmpWage {
    public void addCompany(String name, int wagePerHour, int workingDays, int maxHours);
    public void computeWages();
    public int getTotalWage(String companyName);
}
