package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.devtools.v85.layertree.model.StickyPositionConstraint;

public class SuccessfullRegistrationPage {
    private BaseFunctions baseFunc;
    public SuccessfullRegistrationPage(BaseFunctions baseFunc) {
        this.baseFunc = baseFunc;
    }

    private final By FINAL_TEXT = By.xpath(".//div[@class='finalTxt']");
    private String SUCCESS_MSG = "Thank You for flying with us!";


    public String getSuccessMsg() {
        return SUCCESS_MSG;
    }

    public String getFinalText(){
        return baseFunc.waitForNumberOfElementsToBe(FINAL_TEXT, 1).get(0).getText();
    }

}


