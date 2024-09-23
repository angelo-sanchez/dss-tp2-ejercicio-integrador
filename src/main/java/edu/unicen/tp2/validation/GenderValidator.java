package edu.unicen.tp2.validation;

public class GenderValidator extends Validator {
    private static GenderValidator instance;

    private enum Gender {
        MALE, FEMALE, OTHER
    }

    private GenderValidator() {
    }

    public static GenderValidator getInstance() {
        if (instance == null) {
            instance = new GenderValidator();
        }
        return instance;
    }

    @Override
    public boolean isValid(String value) {
        String gender = value.toUpperCase();
        try {
            Gender.valueOf(gender);
            return true;
        } catch (IllegalArgumentException e) {
            log.error("El género {} no existe", value, e);
            return false;
        }
    }

}
