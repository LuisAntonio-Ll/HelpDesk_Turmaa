package com.turmaa.helpdesk;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelpdeskturmaaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskturmaaApplication.class, args);
	}
	
	@Override
    public void run(String... args) {
        System.out.println("===================================================");
        System.out.println("   APLICAÇÃO HELPDESK INICIADA COM SUCESSO");
        System.out.println("===================================================");
    }
}
