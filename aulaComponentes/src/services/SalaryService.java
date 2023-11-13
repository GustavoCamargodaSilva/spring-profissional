package services;

import entity.Employee;

public class SalaryService {

    TaxService tax = new TaxService();
    PensionService pen = new PensionService();

    public Double netSalary(Employee employee){
        return employee.getGrossSalary()- tax.tax(employee.getGrossSalary()) - pen.discount(employee.getGrossSalary());
    }

}
