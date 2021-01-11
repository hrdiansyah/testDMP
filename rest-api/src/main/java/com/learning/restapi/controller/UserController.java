package com.learning.restapi.controller;

import java.net.URL;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

import org.apache.catalina.User;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.learning.restapi.exception.notFoundException;
import com.learning.restapi.model.jobs;
import com.learning.restapi.model.user;
//import com.learning.restapi.repository.JobsRepository;
import com.learning.restapi.repository.UserRepository;
import com.learning.restapi.service.ConfigService;
import com.learning.restapi.service.JobsService;


@RestController
@RequestMapping(value = "/cachedemo/v1/users")
public class UserController
{
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	JobsService jobsService;
	
	@Autowired
	ConfigService configService;
	
//	@Autowired
//	JobsRepository jobsRepository;
	
	BCryptPasswordEncoder bc;
	
	private static final String JSON_JOBS = "https://jobs.github.com/positions.json";
	private static final String JSON_JOBS_ID = "https://jobs.github.com/positions/{ID}.json";
	
	@PostMapping("/signup")
	public user signUp(@Validated @RequestBody user User) {
		User.setId(UUID.randomUUID().toString());
		User.setUsername(User.getUsername());
		User.setPassword(bc.encode(User.getPassword()));
//		User.setPassword(User.getPassword());
		return User;
	}
	
//	@GetMapping("/getJson")
//	public void json() {
//		jobsService.getAttributes();
//	}
	
//	@RequestMapping(method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public List<jobs> handleAllUserRequest () {
//		return jobsRepository.getAllJobs();
////		jobsService.getAttributes();
//	}

    @GetMapping
    public ResponseEntity<Object> getListJson() {
    	LinkedHashMap<String, Object> res = new LinkedHashMap<>();
    	jobs[] jobList = ((jobs[]) configService.parse(JSON_JOBS));
    	if (jobList != null) {
    		res.put("status", "OK");
            res.put("message", "BERHASIL");
            res.put("data", jobList);
            return ResponseEntity.ok().body(res);
    	}
    	return null;
    	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<Object> getDetailJobsJson(@PathVariable(value = "id")String id) throws notFoundException {
		LinkedHashMap<String, Object> res = new LinkedHashMap<>();
		jobs[] jobList = ((jobs[]) configService.parse(JSON_JOBS+"/"+id));
//		String ids = jobList[0].toString();
//		jobs Jobs = configService.findById(id);
		if (jobList != null) {
			res.put("status", "OK");
	        res.put("message", "BERHASIL");
	        res.put("data", jobList);
	        return ResponseEntity.ok().body(res);
		}
		return null;
		}
	}
	
