package com.example.airplane;




import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;





@SpringBootApplication
@ComponentScan(basePackages = {"com.example.airplane"})
public class AirplaneApplication {
	private static final Logger logger = LogManager.getLogger(AirplaneApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(AirplaneApplication.class, args);
		logger.log(Level.INFO,"Running Main Function...");
		logger.log(Level.INFO, "Exiting the Main Function");
		

	}

}

