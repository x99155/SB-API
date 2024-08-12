package com.process.sa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "test")
public class TestController {

    @GetMapping(path = "string")
    public String getString(){

        return "Chaine de caractère transmise par sa";
    }

    @GetMapping
    public List<String> getList(){
        List<String> maListe = List.of("chaine de caractère", "transmise par sa");
        return maListe;
    }
}
