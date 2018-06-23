package com.msmata.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.msmata.weather.config.JpaConfiguration;


@SpringBootApplication(scanBasePackages={"com.msmata.weather"})
@Import(JpaConfiguration.class)
public class WeatherApiApp {

	public static void main(String[] args) {
		SpringApplication.run(WeatherApiApp.class, args);
	}
}
