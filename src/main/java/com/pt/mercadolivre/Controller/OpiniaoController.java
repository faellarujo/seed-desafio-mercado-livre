package com.pt.mercadolivre.Controller;

import com.pt.mercadolivre.Request.OpiniaoRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpiniaoController {



    @PostMapping(value = "/opiniao", consumes = "application/json")
    public String cadastrarOpiniao(@RequestBody @Valid OpiniaoRequest opiniaoRequest){
        return opiniaoRequest.toString();
    }
}
