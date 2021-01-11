package com.learning.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.learning.restapi.model.jobs;

@Service
public class JsonParsingService implements ConfigService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@Override
	public Object parse(String url) {
		return restTemplate.getForObject(url, jobs[].class);
	}
}
