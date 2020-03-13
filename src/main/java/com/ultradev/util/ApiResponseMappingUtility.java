package com.ultradev.util;

import java.util.Arrays;
import org.dozer.DozerBeanMapper;

public class ApiResponseMappingUtility {
	public static Object mapObject(Object sourceObject, Object destination) {
		DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
		dozerBeanMapper.setMappingFiles(Arrays.asList(ApplicationConstants.DOZER_RESPONSE_MAPPING_XML));
		destination = dozerBeanMapper.map(sourceObject, destination.getClass());
		return destination;
	}

}
