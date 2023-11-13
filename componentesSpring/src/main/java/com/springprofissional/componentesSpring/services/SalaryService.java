package com.springprofissional.componentesSpring.services;


import com.springprofissional.componentesSpring.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //anotation para o serviço da minha aplicaçao
public class SalaryService {

    @Autowired
    private TaxService tax;
    @Autowired
    private PensionService pen;

    public SalaryService(TaxService tax, PensionService pen){ //Inejeçao de dependencia para nao dar controle para a classe SalaryService
        this.tax = tax;
        this.pen = pen;
    };

    public Double netSalary(Employee employee){
        return employee.getGrossSalary()- tax.tax(employee.getGrossSalary()) - pen.discount(employee.getGrossSalary());
    }

}
