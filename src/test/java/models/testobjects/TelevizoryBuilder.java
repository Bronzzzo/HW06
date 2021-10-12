package models.testobjects;
import models.valueobjects.BacklightType;
import models.valueobjects.Company;
import models.valueobjects.DiagonalScreen;
import models.valueobjects.RefreshScreenValue;
public class TelevizoryBuilder {
    private Company company;
    private RefreshScreenValue refreshScreenValue;
    private BacklightType backlightType;
    private DiagonalScreen diagonalScreen;


    public TelevizoryBuilder(Company company, RefreshScreenValue refreshScreenValue, BacklightType backlightType, DiagonalScreen diagonalScreen) {

        this.company = company;
        this.refreshScreenValue = refreshScreenValue;
        this.backlightType = backlightType;
        this.diagonalScreen = diagonalScreen;
    }

    public TelevizoryVO build() {
        TelevizoryVO televizoryVO = new TelevizoryVO();
        televizoryVO.setCompany(this.company);
        televizoryVO.setBacklightType(this.backlightType);
        televizoryVO.setDiagonalScreen(this.diagonalScreen);
        televizoryVO.setRefreshScreenValue(this.refreshScreenValue);
        return televizoryVO;
    }
}
