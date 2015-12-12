package com.inb;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.inb.mongo.repositories.UnregisteredCustomerRepository;
import com.inb.rest.controllers.UnregisteredCustomerController;
import com.inb.rest.entity.Account;
import com.inb.rest.entity.AccountType;
import com.inb.rest.entity.UnregisteredCustomerPOJO;
import com.inb.service.interfaces.UnregisteredCustomerService;
import com.inb.util.AdminUtil;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class App {

	public static void main(String[] args) throws Exception {
		// AdminUtil.populateAdmin();
		SpringApplication.run(App.class, args);

		

	}
}
