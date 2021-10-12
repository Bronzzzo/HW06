package models.testobjects;
import models.valueobjects.BacklightType;
import models.valueobjects.Company;
import models.valueobjects.DiagonalScreen;
import models.valueobjects.RefreshScreenValue;
import java.io.Serializable;

public class TelevizoryVO implements Serializable {
    private Company company;
    private RefreshScreenValue refreshScreenValue;
    private BacklightType backlightType;
    private DiagonalScreen diagonalScreen;

    // Конструктор по умолчанию
    public TelevizoryVO() {
    }

    // Конструктор
    public TelevizoryVO(Company company, RefreshScreenValue refreshScreenValue, BacklightType backlightType, DiagonalScreen diagonalScreen) {
        this.company = company;
        this.refreshScreenValue = refreshScreenValue;
        this.backlightType = backlightType;
        this.diagonalScreen = diagonalScreen;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public RefreshScreenValue getRefreshScreenValue() {
        return refreshScreenValue;
    }

    public void setRefreshScreenValue(RefreshScreenValue refreshScreenValue) {
        this.refreshScreenValue = refreshScreenValue;
    }

    public BacklightType getBacklightType() {
        return backlightType;
    }

    public void setBacklightType(BacklightType backlightType) {
        this.backlightType = backlightType;
    }

    public DiagonalScreen getDiagonalScreen() {
        return diagonalScreen;
    }

    public void setDiagonalScreen(DiagonalScreen diagonalScreen) {
        this.diagonalScreen = diagonalScreen;
    }
}
