package com.tts.ttsWeatherApp.controller;

//import java.util.ArrayList;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.ttsWeatherApp.model.Request;
import com.tts.ttsWeatherApp.model.Response;
import com.tts.ttsWeatherApp.service.WeatherService;

@Controller
public class WeatherController {
	@Autowired
	private WeatherService weatherService;
	
	
	
	//Method to display information stored in the Response.java Model/Class on home page
//	@GetMapping (value="/")
//	public String getIndex(Model model) {
//		Response response = weatherService.getForecast("28078");
//		model.addAttribute("data", response);
//		return "index";
//	}
	
	@GetMapping (value="/")
	public String getIndex(Model model) {
		model.addAttribute("request", new Request());
		return "index";
	}
	//if you don't do value it will utilize a default value
	@PostMapping (value="/")
	public String postIndex(Request request, Model model) {
	    Response data = weatherService.getForecast(request.getZipCode());
	    model.addAttribute("data", data);
	    return "index";
	}
	
}


