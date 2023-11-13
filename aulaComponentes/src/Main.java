import entity.Employee;
import services.PensionService;
import services.SalaryService;
import services.TaxService;

public class Main {
    public static void main(String[] args) {


        Employee emp = new Employee("Gustavo", 4000);
        SalaryService sal = new SalaryService();

        double netSalary = sal.netSalary(emp);
        System.out.println(netSalary);


    }
}