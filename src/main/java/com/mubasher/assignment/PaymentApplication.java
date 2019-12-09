package com.mubasher.assignment;

import com.mubasher.assignment.commons.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.TimeZone;

@EntityScan(basePackages = { "com.mubasher.assignment.domain.entity" })
@SpringBootApplication
@Slf4j
public class PaymentApplication {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone(Constants.UTC));
		SpringApplication.run(PaymentApplication.class, args);
	}

}
