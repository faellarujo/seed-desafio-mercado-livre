package com.pt.mercadolivre.validadores;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class ExistIdValue implements ConstraintValidator<ExistId, Object> {

    private String domainAttribute;
    private Class<?> klass;
    @PersistenceContext
    private EntityManager manager;


    public void initialize(ExistId params) {
        domainAttribute = params.fieldName();
        klass = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        try {
            Query query = manager.createQuery("select 1 from " + klass.getName() + " where " + domainAttribute + " = :value");
            query.setParameter("value", value);
            List<?> list = query.getResultList();
            return !list.isEmpty();
        } catch (Exception e) {
            return true;
        }
    }
}
