package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class CalculatorController {
    private static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);
    private int getCount = 0;
    private int postCount = 0;

    @GetMapping("/calculator")
    public String calculatorForm(Model model) {
        Calculator calc = new Calculator();
        calc.setExpression("");
        model.addAttribute("calculator", calc);
        logger.info("Times getting calculator: " + Integer.toString(++getCount));
        return "calculator";
    }   
    @PostMapping("/calculator")
    public String calculatorSubmit(@ModelAttribute Calculator calculator, Model model) {
        model.addAttribute("calculator", calculator);
        logger.info("Times posting to calculator: " + Integer.toString(++postCount));
        return "calculator";
    }

}