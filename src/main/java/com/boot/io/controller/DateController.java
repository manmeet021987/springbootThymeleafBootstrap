package com.boot.io.controller;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DateController {

	@RequestMapping("/")
	public String welcome(){
		return "index";
	}


	@RequestMapping("/confirm")
	public String daysBetween( Model model,@RequestParam  Date startDate,@RequestParam Date endDate){
		if(startDate.equals(null) || endDate.equals(null))
			model.addAttribute("errorMessage", "Please enter dates"); 
		int noOfDaysBetween= Days.daysBetween(new LocalDate(startDate.getTime()),new LocalDate(endDate.getTime())).getDays();
		model.addAttribute("daysbetween", noOfDaysBetween);

		return "index";
	}
}
