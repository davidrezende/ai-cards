package com.aicards.entity;

public enum AttributesEnum {
    FORCA(1),
    VITALIDADE(2),
    INTELIGENCIA(3),
    DESTREZA(4);

    private final int value;

    AttributesEnum(int value) {
        this.value = value;
    }

    public int getAttribute() {
        return value;
    }
}
