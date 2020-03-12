package com.ultradev.service;

import org.apache.commons.csv.CSVRecord;

@FunctionalInterface
public interface ParsingServiceFacade {
	public Iterable<CSVRecord> parseFeedFileForRecords();
}
