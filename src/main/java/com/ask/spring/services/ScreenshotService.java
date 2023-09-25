package com.ask.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ask.spring.entities.Screenshot;
import com.ask.spring.iservices.IScreenshotService;
import com.ask.spring.repositories.ScreenshotRepository;

@Service
public class ScreenshotService implements IScreenshotService{

	@Autowired 
	ScreenshotRepository srepo;
	@Override
	public Screenshot addScreenshot(Screenshot s) {
		// TODO Auto-generated method stub
		return srepo.save(s);
	}

}
