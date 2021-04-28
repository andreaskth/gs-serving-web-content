package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



//import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/calculator")
    public String calculatorForm(Model model) {
        Calculator calc = new Calculator();
        calc.setExpression("");
        model.addAttribute("calculator", calc);
        return "calculator";
    }   
    @PostMapping("/calculator")
    public String calculatorSubmit(@ModelAttribute Calculator calculator, Model model) {
        model.addAttribute("calculator", calculator);
        return "calculator";
    }

}