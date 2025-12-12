import java.util.ArrayList;
import java.util.HashMap;

public class EmpWageBuilder implements IComputeEmpWage {

    public static final int IS_FULL_TIME = 1;
    public static final int IS_PART_TIME = 2;

    private ArrayList<CompanyEmpWage> companyEmpWageList;
    private HashMap<String, Integer> companyToTotalWageMap;



    public EmpWageBuilder() {
        companyEmpWageList = new ArrayList<>();
        companyToTotalWageMap = new HashMap<>();
    }

    @Override
    public void addCompany(String name, int wagePerHour, int workingDays, int maxHours) {
        CompanyEmpWage company = new CompanyEmpWage(name, wagePerHour, workingDays, maxHours);
        companyEmpWageList.add(company);
    }

    @Override
    public void computeWages() {
        for (CompanyEmpWage company : companyEmpWageList) {
            int totalWage = computeEmpWage(company);
            company.setTotalWage(totalWage);
            companyToTotalWageMap.put(company.company, totalWage);
        }
    }

    @Override
    public int getTotalWage(String companyName) {
        return companyToTotalWageMap.getOrDefault(companyName, 0);
    }

    private int computeEmpWage(CompanyEmpWage company) {
        int totalHours = 0;
        int totalDays = 0;

        while (totalHours <= company.maxHours && totalDays < company.workingDays) {
            totalDays++;
            int empHrs = getEmpHours();
            totalHours += empHrs;
        }

        return totalHours * company.empRatePerHour;
    }

    private int getEmpHours() {
        int empCheck = (int) (Math.random() * 10) % 3;
        switch (empCheck) {
            case IS_FULL_TIME: return 8;
            case IS_PART_TIME: return 4;
            default: return 0;
        }
    }
}
