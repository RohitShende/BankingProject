package com.inb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class App 
{
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World! I am Shariful" ); 
        SpringApplication.run(App.class, args);
    }
}
