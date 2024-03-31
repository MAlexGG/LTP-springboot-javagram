package com.ltp.javagram;

/* import java.util.ArrayList;
import java.util.List; */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class UserController {

    //List<User> users = new ArrayList<>(); 

    @GetMapping("/")
    public String getForm(Model model) {
        model.addAttribute("user", new User());
        return "sign-up";
    }

    @PostMapping("/submitItem")
    public String handleSubmit(@Valid User user, BindingResult result) {
        if(user.getFirstName().equals(user.getLastName())){
            result.rejectValue("firstName", "", "Please enter valid data");
        }
        if(result.hasErrors()) return "sign-up";
        //users.add(user);
        return "redirect:/result";
    }

    @GetMapping("/result")
    public String getResult() {
        return "result";
    }
    
    
    
}
