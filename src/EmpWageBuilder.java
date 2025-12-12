import java.util.ArrayList;
import java.util.Random;

public class EmpWageBuilder {

    private ArrayList<CompanyEmpWage> companyList = new ArrayList<>();
    private Random rand = new Random();


    public void addCompany(String name, int wage, int days, int hours) {
        companyList.add(new CompanyEmpWage(name, wage, days, hours));
    }


    public void computeWages() {
        for (CompanyEmpWage company : companyList) {
            company.totalWage = computeWage(company);
            System.out.println(company);
        }
    }


    private int computeWage(CompanyEmpWage company) {

        int totalHours = 0;
        int totalDays = 0;

        while (totalHours < company.maxHours && totalDays < company.workingDays) {

            int empCheck = rand.nextInt(3); // 0,1,2
            int hours = 0;

            switch (empCheck) {
                case 1:
                    hours = 8;
                    break;
                case 2:
                    hours = 4;
                    break;
                default:
                    hours = 0;
            }

            totalHours += hours;
            totalDays++;

            int dailyWage = hours * company.wagePerHour;


            company.dailyWageList.add(dailyWage);
        }

        return totalHours * company.wagePerHour;
    }


    public static void main(String[] args) {

        EmpWageBuilder builder = new EmpWageBuilder();

        builder.addCompany("D-Mart", 20, 20, 100);
        builder.addCompany("Reliance", 25, 22, 120);

        builder.computeWages();
    }
}
