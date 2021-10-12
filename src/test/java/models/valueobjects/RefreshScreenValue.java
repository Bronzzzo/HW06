package models.valueobjects;

public class RefreshScreenValue {
    private int refreshScreenValue;

    // Конструктор по умолчанию
    public RefreshScreenValue() {
    }

    public RefreshScreenValue(int refreshScreenValue) {
        // Если задано значение меньше 0, то выбросить исключение
        if (refreshScreenValue > 0)
            this.refreshScreenValue = refreshScreenValue;
        else
            throw new IllegalArgumentException("Частота обновления экрана не может быть меньше 0");
    }

//    Геттер

    public int getRefreshScreenValue() {
        return this.refreshScreenValue;
    }

    //    Переопределенный метод сравнения
    public boolean equals(RefreshScreenValue otherRefreshScreenValue) {
        return this.refreshScreenValue == otherRefreshScreenValue.refreshScreenValue;
    }
}
