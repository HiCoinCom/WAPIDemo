package com.chainup.baas;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zyq
 */
@SpringBootApplication
@Slf4j
public class BaasApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaasApplication.class, args);
		log.info("baas start success.......");
	}

}
