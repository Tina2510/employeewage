import java.util.Random;

public class EmpWageBuilder {

    private final int FULL_TIME = 1;
    private final int PART_TIME = 2;

    private CompanyEmpWage[] companyEmpWages;
    private int companyCount = 0;
    private Random rand;


    public EmpWageBuilder(int maxCompanies) {
        companyEmpWages = new CompanyEmpWage[maxCompanies];
        rand = new Random();
    }


    public void addCompanyEmpWage(String companyName, int wagePerHour, int workingDays, int maxHours) {
        companyEmpWages[companyCount++] = new CompanyEmpWage(companyName, wagePerHour, workingDays, maxHours);
    }


    private int getWorkingHours(int empCheck) {
        switch (empCheck) {
            case FULL_TIME: return 8;
            case PART_TIME: return 8;
            default: return 0;
        }
    }

    public void computeWages() {
        for (int i = 0; i < companyCount; i++) {
            CompanyEmpWage company = companyEmpWages[i];
            int totalHours = 0;
            int totalDays = 0;
            int totalWage = 0;

            while (totalHours < company.maxHours && totalDays < company.workingDays) {
                int empCheck = rand.nextInt(3);
                int hoursWorked = getWorkingHours(empCheck);
                totalHours += hoursWorked;
                totalWage += hoursWorked * company.wagePerHour;
                totalDays++;
            }

            company.setTotalWage(totalWage);
            System.out.println(company);
        }
    }


    public static void main(String[] args) {
        EmpWageBuilder empWageBuilder = new EmpWageBuilder(5); // can manage up to 5 companies


        empWageBuilder.addCompanyEmpWage("TCS", 20, 20, 100);
        empWageBuilder.addCompanyEmpWage("Infosys", 25, 22, 120);
        empWageBuilder.addCompanyEmpWage("Wipro", 30, 18, 90);


        empWageBuilder.computeWages();
    }
}
