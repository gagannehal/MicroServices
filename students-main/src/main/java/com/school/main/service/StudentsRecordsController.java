package com.school.main.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

import com.school.main.model.Students;


@RestController
public class StudentsRecordsController {
	
	Logger logger = LoggerFactory.getLogger(StudentsRecordsController.class);
	
	@Autowired
    private RestTemplate restTemplate;
	
	@Autowired
    private WebClient.Builder webClient;
	
	@Autowired
	private WebClient defaultWebClient;
	

	@GetMapping("/getAll")
	@ResponseBody
	public Students getStudents() {
		
		
		
		Students std = restTemplate.getForObject("http://localhost:9091/students/", Students.class);
        //System.out.println("RESPONSE " + std);
		return std;
	}
	
	@GetMapping("/getWeb")
	@ResponseBody
	public Students getStudentsViaWeb() {
		
		Students std = webClient
						.build()
						.get()
						.uri("http://localhost:9091/students/")
						.retrieve()
						.bodyToMono(Students.class)
						.block();
        //System.out.println("RESPONSE " + std);
		return std;
	}
	
	
	
	@GetMapping("/getValue")
	@ResponseBody
	public Students getStudentsViaInterceptor() {
		
		Students std = defaultWebClient
						.get()
						.uri("9091/students/")
						.retrieve()
						.bodyToMono(Students.class)
						.block();
		return std;
	}
	
	
	/*
	 * WebClient webClientBuilder = WebClient.builder()
	 * .baseUrl("http://localhost:8080|") .filter(logFilter()) .build();
	 * 
	 * 
	 * private ExchangeFilterFunction logFilter() { return (clientRequest, next) ->
	 * { logger.info("External Request to {}", clientRequest.url()); return
	 * next.exchange(clientRequest); }; }
	 */
	
}




