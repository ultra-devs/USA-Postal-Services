package com.ultradev.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ultradev.dao.entity.ZipCodeInfo;
import com.ultradev.dao.repo.ZipCodeRepository;
import com.ultradev.util.FeedFileColumnIdentifiers;
import com.ultradev.util.LOG;

/**
 * 
 * @author shashank
 *
 */
@Service
public class FeedFileDataParsingService {
	@Autowired
	ZipCodeRepository zipCodeRepository;

	@Autowired
	ParsingServiceFacade parsingServiceFacade; // hiding the underneath CSV format implementation

	Logger logger = LoggerFactory.getLogger(FeedFileDataParsingService.class);

	/**
	 * 
	 * Mar 12, 2020
	 * 
	 * @uthor shashank
	 *
	 */
	public void parseZipFile() throws IOException {
		Iterable<CSVRecord> countyzipRecords = parsingServiceFacade.parseFeedFileForRecords();
		List<ZipCodeInfo> allZipcodeList = new ArrayList<>();
		StopWatch stopWatch = StopWatch.createStarted();
		for (CSVRecord record : countyzipRecords) {
			allZipcodeList.add(populateZipCodeInfoFromFeedFileRow(record));
		}

		stopWatch.stop();

		zipCodeRepository.saveAll(allZipcodeList);
		logger.info(LOG.FEED_FILE_RECORD_COUNT.val() + ":{}", allZipcodeList.size());

		logger.info(LOG.DATA_LOAD_COMPLETED.val() + ":{}", stopWatch.toString() + " )");
	}

	/**
	 * 
	 * @param record
	 * @return
	 */
	private ZipCodeInfo populateZipCodeInfoFromFeedFileRow(CSVRecord record) {
		ZipCodeInfo zipCodeInfo = new ZipCodeInfo();
		zipCodeInfo.setCountry(record.get(FeedFileColumnIdentifiers.country.val()));
		zipCodeInfo.setPostalcode((record.get(FeedFileColumnIdentifiers.postalcode.val())));
		zipCodeInfo.setPlace((record.get(FeedFileColumnIdentifiers.place.val())));
		zipCodeInfo.setAdminname1(record.get(FeedFileColumnIdentifiers.adminname1.val()));
		zipCodeInfo.setAdmincode1(record.get(FeedFileColumnIdentifiers.admincode1.val()));
		zipCodeInfo.setAdminname2(record.get(FeedFileColumnIdentifiers.adminname2.val()));
		zipCodeInfo.setAdmincode2(record.get(FeedFileColumnIdentifiers.admincode2.val()));
		zipCodeInfo.setAdminname3(record.get(FeedFileColumnIdentifiers.adminname3.val()));
		zipCodeInfo.setAdmincode3(record.get(FeedFileColumnIdentifiers.admincode3.val()));
		String longitude = record.get(FeedFileColumnIdentifiers.longitude.val());
		String lattitude = record.get(FeedFileColumnIdentifiers.lattitude.val());
		String accuracy = record.get(FeedFileColumnIdentifiers.accuracy.val());
		if (isValidNumberFormat(longitude))
			zipCodeInfo.setLongitude(Double.parseDouble(longitude));
		if (isValidNumberFormat(lattitude))
			zipCodeInfo.setLattitude(Double.parseDouble(lattitude));
		if (isValidNumberFormat(accuracy))
			zipCodeInfo.setAccuracy(Integer.parseInt(accuracy));
		return zipCodeInfo;

	}

	private boolean isValidNumberFormat(String candidateValue) {

		if (StringUtils.isNotEmpty(candidateValue)) // any other filter/checks if required
		{
			return true;
		}
		return false;

	}
}
