package br.com.wesleysistemas.sistemadeatas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;

@SpringBootApplication
@EnableRetry
public class SistemaDeAtasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaDeAtasApplication.class, args);
	}

}
