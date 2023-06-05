package com.kraft.pages;

import com.kraft.utilities.BrowserUtils;
import com.kraft.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//ul[@class='d-flex align-items-center']/li")
    public List<WebElement> tabNames;

    @FindBy(xpath = "//span[text()='Login']")
    public WebElement loginBtn;

    public void navigateTabAndModule(String tabName){
        WebElement tab = Driver.get().findElement(By.xpath("//span[text()='"+tabName+"']"));
        tab.click();
    }
    public void navigateTabAndModule(String tabName,String moduleName) {
        WebElement tab = Driver.get().findElement(By.xpath("//span[text()='" + tabName + "']"));
        tab.click();
        if (tabName.equals("JavaScript") && moduleName.equals("Alerts")) {
            WebElement module = Driver.get().findElement(By.xpath("(//span[text()='Alerts'])[2]"));
            BrowserUtils.clickWithJS(module);
        } else {
            WebElement module = Driver.get().findElement(By.xpath("//span[text()='" + moduleName + "']"));
            BrowserUtils.clickWithJS(module);
        }
    }

    public void logoutAndNavigateToLoginPage(String userName){
        navigateTabAndModule(userName,"Sign Out");
        loginBtn.click();
    }
}
