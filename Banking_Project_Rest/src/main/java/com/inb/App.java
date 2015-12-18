package com.inb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import com.inb.util.AdminUtil;

/**
 * iNB App main
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@ImportResource("Spring-Mail.xml")
public class App {

	public static void main(String[] args) throws Exception {
		AdminUtil.populateAdmin();
		SpringApplication.run(App.class, args);
	}
}
