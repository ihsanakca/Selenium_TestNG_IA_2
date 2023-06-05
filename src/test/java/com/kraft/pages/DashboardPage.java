package com.kraft.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{

    @FindBy(xpath = "//li[text()='Dashboard']")
    public WebElement dashboardPageSubTitle;

    @FindBy(css = "h2")
    public WebElement userName;

    @FindBy (css = "h3")
    public WebElement userJob;



}
