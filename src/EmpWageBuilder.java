import java.util.Random;

public class EmpWageBuilder implements IComputeEmpWage {

    private CompanyEmpWage[] companyEmpArray;
    private int index;
    private Random rand;

    public EmpWageBuilder(int companyCount) {
        companyEmpArray = new CompanyEmpWage[companyCount];
        index = 0;
        rand = new Random();
    }

    @Override
    public void addCompanyEmpWage(String companyName, int wagePerHour, int workingDays, int maxHours) {
        companyEmpArray[index++] = new CompanyEmpWage(companyName, wagePerHour, workingDays, maxHours);
    }


    private int computeWage(CompanyEmpWage company) {

        int totalHours = 0;
        int totalDays = 0;

        while (totalHours < company.maxHours && totalDays < company.workingDays) {

            int empCheck = rand.nextInt(3);
            int hours = 0;

            switch (empCheck) {
                case 1: hours = 8; break;
                case 2: hours = 4; break;
                default: hours = 0;
            }

            totalHours += hours;
            totalDays++;
        }

        return totalHours * company.wagePerHour;
    }

    @Override
    public void computeWages() {
        for (int i = 0; i < index; i++) {
            CompanyEmpWage company = companyEmpArray[i];
            int totalWage = computeWage(company);
            company.totalWage = totalWage;
            System.out.println(company);
        }
    }

    public static void main(String[] args) {

        IComputeEmpWage empWageBuilder = new EmpWageBuilder(5);

        empWageBuilder.addCompanyEmpWage("TCS", 20, 20, 100);
        empWageBuilder.addCompanyEmpWage("Infosys", 25, 22, 120);
        empWageBuilder.addCompanyEmpWage("Wipro", 30, 18, 90);

        empWageBuilder.computeWages();
    }
}
