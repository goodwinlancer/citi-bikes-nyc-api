package com.poor.ugly.dwarf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping

public class Controller {

	private ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
	private CommonResponse response = null;

	//Read the property value from application.properties
	@Value("${app.citi.bikes.nyc.url}")
	private String uri;

	// GET method that returns the list of stations
	@GetMapping("/getstations")
	public CommonResponse search() throws Exception {

		try {
			mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);

			//Preparing REST Template
			printLog(null, "Preparing REST Template");
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
			restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
			
			//Calling Station API
			printLog(null, "Calling stations API");			
			StationResponse result = restTemplate.getForObject(uri, StationResponse.class);

			printLog(result, "Response received from API call");
			MessageResponse messageRes = new MessageResponse(200, "List of stations fetched successfully");

			response = new CommonResponse(result.getStationBeanList(), messageRes, false, false);
		} catch (Exception ex) {
			printLog(ex.getStackTrace(), ex.getMessage());
			MessageResponse messageRes = new MessageResponse(422, "Error fetching list of stations. Please see server log for details");
			response = new CommonResponse(null, messageRes, false, false);
		}

		return response;
	}

	private void printLog(Object obj, String message) throws JsonProcessingException {
		if (obj != null && message != null) {
			String json = mapper.writeValueAsString(obj);
			log.debug(message + ": " + json);
		} else if (obj == null && message != null) {
			log.debug(message);
		} else {
			// Do nothing
		}
	}

}