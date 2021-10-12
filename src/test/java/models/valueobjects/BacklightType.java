package models.valueobjects;

import java.io.Serializable;

public class BacklightType implements Serializable {
    private String backlightType;


    //Конструктор
    public BacklightType() {
    }

    //Конструктор с проверкой
    public BacklightType(String backlightType) {
        if (!backlightType.isBlank() || !backlightType.isEmpty())
            this.backlightType = backlightType;
        else
            throw new IllegalArgumentException("Тип подсветки экрана не может быть пустым");
    }



    //Геттер
    public String getBacklightType() {
        return backlightType;
    }

    //    Переопределенный метод сравнения
    public boolean equals(BacklightType otherBacklightType) {
        return this.backlightType.equals(otherBacklightType);
    }
}
