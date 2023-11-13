import entity.Employee;
import services.PensionService;
import services.SalaryService;
import services.TaxService;

public class Main {
    public static void main(String[] args) {


        Employee emp = new Employee("Gustavo", 4000);
        TaxService tax = new TaxService();
        PensionService pen = new PensionService();

        SalaryService sal = new SalaryService(tax,pen);//instanciando o service fazendo a injeçao de dependencia

        double netSalary = sal.netSalary(emp);
        System.out.println(netSalary);


    }
}