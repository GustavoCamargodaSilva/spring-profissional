package services;

import entity.Employee;

public class SalaryService {

    private TaxService tax;
    private PensionService pen;

    public SalaryService(TaxService tax, PensionService pen){ //Inejeçao de dependencia para nao dar controle para a classe SalaryService
        this.tax = tax;
        this.pen = pen;
    };

    public Double netSalary(Employee employee){
        return employee.getGrossSalary()- tax.tax(employee.getGrossSalary()) - pen.discount(employee.getGrossSalary());
    }

}
