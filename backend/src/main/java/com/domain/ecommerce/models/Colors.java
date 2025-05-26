package com.domain.ecommerce.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Colors {
    RED("vermelho"),
    YELLOW("amarelo"),
    BLUE("azul"),
    GREEN("verde"),
    BLACK("preto"),
    PURPLE("roxo");

    private final String label;

    Colors(String label) {
        this.label = label;
    }

    @JsonValue
    public String getLabel() {
        return label;
    }

    @JsonCreator
    public static Colors fromLabel(String label) {
        for (Colors c : Colors.values()) {
            if (c.label.equalsIgnoreCase(label)) {
                return c;
            }
        }
        throw new IllegalArgumentException("Cor inválida: " + label);
    }
}
