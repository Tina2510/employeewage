public class Main {
    public static void main(String[] args) {
        EmpWageBuilder empBuilder = new EmpWageBuilder();
        empBuilder.addCompany("ABC Corp", 20, 20, 100);
        empBuilder.addCompany("XYZ Ltd", 25, 22, 120);

        empBuilder.computeWages();

        System.out.println("Total wage for ABC Corp: " + empBuilder.getTotalWage("ABC Corp"));
        System.out.println("Total wage for XYZ Ltd: " + empBuilder.getTotalWage("XYZ Ltd"));
    }
}
