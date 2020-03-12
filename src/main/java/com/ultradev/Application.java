package com.ultradev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ultradev.service.FeedFileDataParsingService;

@SpringBootApplication
/**
 * 
 * @author shanky
 *
 */
public class Application implements CommandLineRunner {
	@Autowired
	FeedFileDataParsingService fileParserService;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		fileParserService.parseZipFile();
	}

}