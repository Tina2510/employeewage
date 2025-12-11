import java.util.ArrayList;
import java.util.Random;

public class EmpWageBuilder implements IComputeEmpWage {

    private ArrayList<CompanyEmpWage> companyList;
    private Random rand;

    public EmpWageBuilder() {
        companyList = new ArrayList<>();
        rand = new Random();
    }


    @Override
    public void addCompanyEmpWage(String companyName, int wagePerHour, int workingDays, int maxHours) {
        companyList.add(new CompanyEmpWage(companyName, wagePerHour, workingDays, maxHours));
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
        for (CompanyEmpWage company : companyList) {
            int totalWage = computeWage(company);
            company.totalWage = totalWage;
            System.out.println(company);
        }
    }


    public static void main(String[] args) {

        IComputeEmpWage empWageBuilder = new EmpWageBuilder();

        empWageBuilder.addCompanyEmpWage("TCS", 20, 20, 100);
        empWageBuilder.addCompanyEmpWage("Infosys", 25, 22, 120);
        empWageBuilder.addCompanyEmpWage("Wipro", 30, 18, 90);

        empWageBuilder.computeWages();
    }
}
