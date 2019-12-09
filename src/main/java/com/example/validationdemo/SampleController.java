package com.example.validationdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleController {

    @GetMapping("/index")
    public String index( InputForm inputForm){
        return "sample/index";
    }

    @PostMapping("/input")
    public String input(@Validated(AlphaGroup.class) InputForm inputForm, BindingResult error, Model model){
        if(error.hasErrors()){
            return "sample/index";
        }

        return "sample/result";
    }

}
