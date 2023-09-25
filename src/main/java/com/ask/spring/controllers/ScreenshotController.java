package com.ask.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ask.spring.entities.Screenshot;
import com.ask.spring.iservices.IScreenshotService;

@RestController
@RequestMapping("/screen")
@CrossOrigin(origins="http://localhost:4200")
public class ScreenshotController {
	@Autowired
	IScreenshotService screenserv;
	
	//http://localhost:8080/PFE/client/add
	@PostMapping("/add")
	public Screenshot addScreenshot(@RequestBody Screenshot s ){
		return screenserv.addScreenshot(s);
	}
	

}
