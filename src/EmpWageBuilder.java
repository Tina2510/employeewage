import java.util.Random;

public class EmpWageBuilder {

    private final int FULL_TIME = 1;
    private final int PART_TIME = 2;

    private CompanyEmpWage companyEmpWage;
    private Random rand;


    public EmpWageBuilder(CompanyEmpWage companyEmpWage) {
        this.companyEmpWage = companyEmpWage;
        this.rand = new Random();
    }


    private int getWorkingHours(int empCheck) {
        switch (empCheck) {
            case FULL_TIME: return 8;
            case PART_TIME: return 8;
            default: return 0;
        }
    }


    public void computeWage() {
        int totalHours = 0;
        int totalDays = 0;
        int totalWage = 0;

        while (totalHours < companyEmpWage.maxHours && totalDays < companyEmpWage.workingDays) {
            int empCheck = rand.nextInt(3);
            int hoursWorked = getWorkingHours(empCheck);
            totalHours += hoursWorked;
            totalWage += hoursWorked * companyEmpWage.wagePerHour;
            totalDays++;
        }


        companyEmpWage.setTotalWage(totalWage);
        System.out.println(companyEmpWage);
    }


    public static void main(String[] args) {

        CompanyEmpWage tcs = new CompanyEmpWage("TCS", 20, 20, 100);
        CompanyEmpWage infosys = new CompanyEmpWage("Infosys", 25, 22, 120);
        CompanyEmpWage wipro = new CompanyEmpWage("Wipro", 30, 18, 90);


        EmpWageBuilder empTCS = new EmpWageBuilder(tcs);
        EmpWageBuilder empInfosys = new EmpWageBuilder(infosys);
        EmpWageBuilder empWipro = new EmpWageBuilder(wipro);


        empTCS.computeWage();
        empInfosys.computeWage();
        empWipro.computeWage();
    }
}
