package com.pt.mercadolivre.validadores;

import com.pt.mercadolivre.Request.CaracteristicaRequest;
import com.pt.mercadolivre.Request.ProdutoRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

public class ProibeCaracteristicasComNomesIguaisValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return ProdutoRequest.class.isAssignableFrom(clazz); // verifica se a classe é a mesma ou está relacionada filha
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }
        ProdutoRequest request = (ProdutoRequest) target;
        if (request.temCaracteristicasIguais()){
            errors.rejectValue("caracteristicas", null, "Você tem caracteristicas iguais no Nome: " + request.getNome());
        }
    }
}
