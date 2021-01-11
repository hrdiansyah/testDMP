package com.learning.restapi.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.jar.Attributes;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JobsService {
	public String url = "https://jobs.github.com/positions.json";
	private static RestTemplate restTemplate;

//    @Autowired
//    public String CService(String url) {
//        this.url = url;
//        return null;
//    }

    public String getAttributes() {
        HttpHeaders headers= new HttpHeaders();
        headers.add("Authorization", "some value");
        HttpEntity<String> request = new HttpEntity<String>(headers);
        ResponseEntity<Attributes> response = restTemplate.exchange(url, HttpMethod.GET, request, Attributes.class);
        return url;
    }
    
//    public jobs() 
//    {
//    	try {
//			URL url = new URL("https://jobs.github.com/positions.json");
//			HttpsURLConnection hr= (HttpsURLConnection)url.openConnection();
//			System.out.println(hr.getResponseCode());
//			if (hr.getResponseCode()== 200) {
//				InputStream im = hr.getInputStream();
//				StringBuffer sb = new StringBuffer();
//				BufferedReader br = new BufferedReader(new InputStreamReader(im));
//				String line = br.readLine();
//				while(line!=null) {
//					System.out.println(line);
//					line = br.readLine();
//				}
//			}
//		} catch(Exception e) {
//			
//		}
//    }
}
