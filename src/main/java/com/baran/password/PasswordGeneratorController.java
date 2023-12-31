package com.baran.password;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PasswordGeneratorController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
    @PostMapping("/generate")
    private String generate(@RequestParam int taille, Model modele){
        Password_gen generator = new Password_gen(taille);
        String password = generator.create();
        modele.addAttribute("password",password);
        return "result";
    }
}
