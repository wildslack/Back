package fr.wildcodeschool.wildslackback.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(value="/")
    public String home() {
        return "Bienvenu sur la landing page";
    }

    @GetMapping(value="private")
    public String privateArea() {
        return "vous authentifié commencé à discuter";
    }
}
