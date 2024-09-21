package edu.unicen.tp2.validation;

import java.util.Set;

public class StudentAttributeValidator extends Validator {
    Set<String> validAttributeNames = Set.of(
            "firstName",
            "lastName",
            "age",
            "documentNumber",
            "universityBookNumber",
            "gender",
            "cityOfResidence");

    @Override
    public boolean isValid(String value) {
        return validAttributeNames.contains(value);
    }

}
