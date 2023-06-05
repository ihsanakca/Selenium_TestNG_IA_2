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

    @FindBy(xpath = "//label[text()='School or Bootcamp *']")
    public WebElement schoolOrBootCamp;

    @FindBy(xpath = "//label[text()='Degree or Certificate *']")
    public WebElement degreeOrCertificate;

    @FindBy(css = "input#degree")
    public WebElement degreOrCertificateInputBox;

    @FindBy(xpath = "//label[text()='Study ']")
    public WebElement study;

    @FindBy(xpath = "//div/button[text()='Add Education']")
    public WebElement addEducationBtn;

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
