package edu.unicen.tp2.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Validator {
    protected static final Logger log = LoggerFactory.getLogger(Validator.class);
    protected Validator() {}
    static Validator getInstance() {
        throw new IllegalAccessError("No se puede instanciar la clase Validator");
    }

    public abstract boolean isValid(String value);
}
