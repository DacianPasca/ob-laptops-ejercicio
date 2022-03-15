package com.obspring.obh2jpawebdevtools;

import com.obspring.obh2jpawebdevtools.entities.Laptop;
import com.obspring.obh2jpawebdevtools.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ObH2JpaWebDevtoolsApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ObH2JpaWebDevtoolsApplication.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);


		// CRUD
		// crea laptop
		Laptop laptop1 = new Laptop(null, "MSI", "ZeusZ3", 2020, 499.99, true);
		Laptop laptop2 = new Laptop(null, "AORUS", "Beta5P", 2021, 649.99, true);

		// almacenar un laptop
		repository.save(laptop1);
		repository.save(laptop2);
	}

}
