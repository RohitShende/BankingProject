package com.inb;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

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
		AdminUtil.populateAdmin();
		System.out.println("populated...");
		//SpringApplication.run(App.class, args);
	}
}
