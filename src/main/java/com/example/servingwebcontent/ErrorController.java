package com.example.servingwebcontent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ErrorController {

	private static final Logger logger = LoggerFactory.getLogger(ErrorController.class);

	@GetMapping("/generate-errors")
	public String generateErrors(@RequestParam(name="count", required=false, defaultValue="10") String count, Model model) {
		int nrOfErrors = Integer.parseInt(count);

		for (int i = 0; i < nrOfErrors; i++) {
			logger.error("Error generated in /generate-errors: " + i);
		}

		model.addAttribute("count", count);
		return "error";
	}

}
