package com.kraft.pages;

import com.kraft.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddEducationPage extends BasePage {

    @FindBy(xpath = "//li//button[text()='Add Education']")
    public WebElement addEducationPageSubTitle;

    public void addEducationMtd(String school, String degreeOrCertificate, String study, String fromDate, String toDate, String programDescription) {
        Actions actions = new Actions(Driver.get());

        WebElement schoolName = Driver.get().findElement(By.id("school"));
        actions.click(schoolName)
                .sendKeys(school+ Keys.TAB)
                .sendKeys(degreeOrCertificate+Keys.TAB)
                .sendKeys(study+Keys.TAB)
                .sendKeys(fromDate+Keys.TAB+Keys.TAB)
                .sendKeys(toDate+Keys.TAB)
                .sendKeys(programDescription+Keys.TAB+Keys.ENTER).perform();
    }
}
