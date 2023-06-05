package com.kraft.pages;

import com.kraft.utilities.BrowserUtils;
import com.kraft.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverviewPage extends BasePage {

    @FindBy(xpath = "//button[text()='Overview']")
    public WebElement overviewPageSubTitle;

    @FindBy(xpath = "//table//tr[contains(@id,'itemedu')]/td[2]")
    public WebElement addedLastEducationSchoolName;



    public void navigateUserProfileTabs(String tabName) {
        WebElement profileTab = Driver.get().findElement(By.xpath("//li/button[text()='" + tabName + "']"));
        BrowserUtils.clickWithJS(profileTab);
    }
    public String addedEducationName(String schoolName) {
        return Driver.get().findElement(By.xpath("//span[text()='" + schoolName + "']")).getText();
    }

    public void deleteEducation(String addedEducation) {
        // WebElement deleteEducationBtn = Driver.get().findElement(By.xpath("//span[text()='" + addedEducation + "']/../following-sibling::td[@width='30px']/a"));
        WebElement deleteEducationBtn = Driver.get().findElement(By.xpath("//span[text()='"+addedEducation+"']/ancestor::tr//a"));

        BrowserUtils.waitForClickablility(deleteEducationBtn, 7);
        BrowserUtils.clickWithJS(deleteEducationBtn);
        Alert alert = Driver.get().switchTo().alert();
        BrowserUtils.waitFor(2);
        alert.accept();
    }

}
