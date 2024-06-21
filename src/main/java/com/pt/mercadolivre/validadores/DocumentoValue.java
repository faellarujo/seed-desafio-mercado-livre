package com.pt.mercadolivre.validadores;

import com.pt.mercadolivre.exception.DocumentoInvalido;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DocumentoValue implements ConstraintValidator<Documento, Object> {

    @Override
    public void initialize(Documento constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        new DocumentoInvalido("Documento inválido");
        return false;
    }
}
