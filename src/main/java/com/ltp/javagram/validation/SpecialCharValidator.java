package com.ltp.javagram.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SpecialCharValidator implements ConstraintValidator<SpecialChar, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Pattern pattern = Pattern.compile("[^a-z0-9]");
        Matcher matcher = pattern.matcher(value);
        boolean badCharacters = matcher.find();
        if(!badCharacters){
            return true;
        }
        return false;
    }

}
