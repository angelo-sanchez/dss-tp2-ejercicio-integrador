package edu.unicen.tp2.validation;

public final class ValidatorFactory {
    private ValidatorFactory() {
    }

    public static Validator getValidator(String attribute) {
        switch (attribute) {
            case "gender":
                return GenderValidator.getInstance();
            default:
                throw new IllegalArgumentException("No se encontró un validador para el atributo " + attribute);
        }
    }
}
