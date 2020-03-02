package com.tts.ttsWeatherApp.service;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.tts.ttsWeatherApp.model.Response;
//import com.tts.ttsWeatherApp.repository.ZipCodeRepository;


@Service
public class WeatherService {
		
//		@Autowired
//		private ZipCodeRepository zipCodeRepository;

//		@Autowired
//		public WeatherService (ZipCodeRepository zipCodeRepository) {
//			this.zipCodeRepository = zipCodeRepository;
//		}
	
	    @Value("${api_key}")
	    private String apiKey;
	    
	    //public method (getforcast) for making HTTP request to that specific URLand store info in Response class
	    public Response getForecast(String zipCode) {
	    	//set end point URL based on zipcode and individual apikey
	        String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + 
	            zipCode + "&units=imperial&appid=" + apiKey;
	        //create a restTenplate and a new instance of it
	        RestTemplate restTemplate = new RestTemplate();
	        try {
	            return restTemplate.getForObject(url, Response.class);
	        }
	        catch (HttpClientErrorException ex) {
	            Response response = new Response();
	            response.setName("error");
	            return response;
	        }
//	        return restTemplate.getForObject(url, Response.class);
//	        //All of this makes an HTTP request to URL based on the response class
	    }

}
