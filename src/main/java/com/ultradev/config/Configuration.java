package com.ultradev.config;

import java.io.InputStreamReader;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

import com.ultradev.service.ParsingServiceFacade;

@org.springframework.context.annotation.Configuration
public class Configuration {

	@Value("${feed.source}")
	Resource resourceFile;
	CSVFormat usedcsvFormat = CSVFormat.TDF; // TAB DELIMETED FILE
	// CSVFormat usedcsvFormat= CSVFormat.EXCEL; // TAB DELIMETED FILE

	@Bean
	public ParsingServiceFacade getFeedFileRecords() {
		return () -> getParsingService();

	}

	private Iterable<CSVRecord> getParsingService() {
		Iterable<CSVRecord> countyzipRecords = null;
		try {
			Reader in = new InputStreamReader(resourceFile.getInputStream());
			countyzipRecords = usedcsvFormat.parse(in);
		} catch (Exception e) {
			System.err.println(e);
		}
		return countyzipRecords;

	}

}
