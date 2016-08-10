package com.target.myretail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.target.myretail.util.EmbeddedDatabase;

@SpringBootApplication
public class MyRetailApplication implements CommandLineRunner {
	
	@Autowired
	EmbeddedDatabase embeddedDatabase;
	
	public static void main(String[] args) {
		SpringApplication.run(MyRetailApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		embeddedDatabase.initializeCassandra();
	}

}
