package com.springprofissional.desafioComponentes;

import com.springprofissional.desafioComponentes.entities.Order;
import com.springprofissional.desafioComponentes.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class DesafioComponentesApplication implements CommandLineRunner {

	Scanner sc = new Scanner(System.in);

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(DesafioComponentesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Order order = new Order();
		System.out.println("Digite o código pedido: ");
		order.setCode(sc.nextInt());
		System.out.println("Digite o valor basico: ");
		order.setBasic(sc.nextDouble());
		System.out.println("Porcetagem de desconto: ");
		order.setDiscount(sc.nextDouble());

		double valorFinal = orderService.total(order);

		System.out.println("SAIDA");

		System.out.println("Pedido código: " + order.getCode());
		System.out.println("valor total: " + valorFinal);


	}
}