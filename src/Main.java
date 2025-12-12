public class Main {
    public static void main(String[] args) {
        EmpWageBuilder empBuilder = new EmpWageBuilder();

        empBuilder.addCompany("ABC Corp", 20, 20, 100);
        empBuilder.addCompany("XYZ Ltd", 25, 22, 120);
        empBuilder.addCompany("PQR Inc", 30, 25, 150);

        empBuilder.computeWages();

        System.out.println("=== UC13: Query Total Wages ===");
        System.out.println("ABC Corp: " + empBuilder.getTotalWage("ABC Corp"));
        System.out.println("XYZ Ltd: " + empBuilder.getTotalWage("XYZ Ltd"));
        System.out.println("PQR Inc: " + empBuilder.getTotalWage("PQR Inc"));

        System.out.println("\n=== UC13: Detailed Company Info ===");
        CompanyEmpWage xyz = empBuilder.getCompanyDetails("XYZ Ltd");
        if (xyz != null) {
            System.out.println("Company: " + xyz.company +
                    ", Total Wage: " + xyz.totalWage +
                    ", Working Days: " + xyz.workingDays +
                    ", Max Hours: " + xyz.maxHours);
        }
    }
}
