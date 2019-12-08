package com.example.validationdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.validation.Valid;

import static java.lang.System.in;

@Controller
public class SampleController {

    @GetMapping("/hoge")
    public String hoge( InputForm inputForm){
        return "sample/hoge";
    }

    @PostMapping("/input")
    public String input(@Validated(AlphaGroup.class) InputForm inputForm, BindingResult error, Model model){
        if(error.hasErrors()){
            String msg = "";
            for (ObjectError e : error.getAllErrors()) {
                msg = msg + e.getDefaultMessage();
            }

            model.addAttribute("message", msg);
            return "sample/hoge";
        }

        return "sample/result";
    }

}
