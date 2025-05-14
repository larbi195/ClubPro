package com.example.clubprojava.model;

import com.example.clubprojava.model.Enum.ColorJersey;
import com.example.clubprojava.model.Enum.TypeJersey;

public class Jersey {
    private TypeJersey typeJersey;
    private ColorJersey primaryColor;
    private ColorJersey secondaryColor;

    public Jersey(TypeJersey typeJersey, ColorJersey primaryColor, ColorJersey secondaryColor) {
        this.typeJersey = typeJersey;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
    }

    public TypeJersey getTypeJersey() {
        return typeJersey;
    }

    public void setTypeJersey(TypeJersey typeJersey) {
        this.typeJersey = typeJersey;
    }

    public ColorJersey getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(ColorJersey primaryColor) {
        this.primaryColor = primaryColor;
    }

    public ColorJersey getSecondaryColor() {
        return secondaryColor;
    }

    public void setSecondaryColor(ColorJersey secondaryColor) {
        this.secondaryColor = secondaryColor;
    }
}
