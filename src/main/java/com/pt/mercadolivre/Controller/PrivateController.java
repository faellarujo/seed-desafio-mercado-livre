package com.pt.mercadolivre.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrivateController {

    @GetMapping("/private")
    public String getMessage() {
        return "This is a private endpoint";
    }
}
