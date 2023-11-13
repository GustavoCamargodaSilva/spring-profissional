package com.springprofissional.componentesSpring;

import com.springprofissional.componentesSpring.entities.Employee;
import com.springprofissional.componentesSpring.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ComponentesSpringApplication implements CommandLineRunner {

	@Autowired
	private SalaryService salaryService;

	public static void main(String[] args) {

		SpringApplication.run(ComponentesSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee("Gustavo",4000);
		System.out.println(salaryService.netSalary(employee));
	}
}
