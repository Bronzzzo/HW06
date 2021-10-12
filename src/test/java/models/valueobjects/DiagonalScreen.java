package models.valueobjects;

import java.io.Serializable;
import java.util.Objects;

public class DiagonalScreen implements Serializable {
    private int minDiagonalScreen;
    private int maxDiagonalScreen;

    //Конструктор
    public DiagonalScreen(int i) {
    }
//    Конструктор класса


    public DiagonalScreen(int minDiagonalScreen, int maxDiagonalScreen) {
        if (minDiagonalScreen >= 60 && minDiagonalScreen <= 80 && maxDiagonalScreen >=60 && maxDiagonalScreen<=80) {
            this.minDiagonalScreen = minDiagonalScreen;
            this.maxDiagonalScreen = maxDiagonalScreen;
        }else
            throw new IllegalArgumentException("Диагональ экрана выходит за диапазон заданных значений");

    }
//    Геттеры

    public int getMinDiagonalScreen() {
        return minDiagonalScreen;
    }

    public int getMaxDiagonalScreen() {
        return maxDiagonalScreen;
    }

//

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiagonalScreen that = (DiagonalScreen) o;
        return minDiagonalScreen == that.minDiagonalScreen && maxDiagonalScreen == that.maxDiagonalScreen;
    }

    @Override
    public int hashCode() {
        return Objects.hash(minDiagonalScreen, maxDiagonalScreen);
    }
}
