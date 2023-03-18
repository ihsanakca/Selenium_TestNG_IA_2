package com.kraft.pages;

import com.kraft.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddExperiencePage extends BasePage {

    @FindBy(xpath = "//li/button[text()='Add Experience']")
    public WebElement addExperiencePageSubTitle;

    public void addExperienceMtd(){
        Actions actions=new Actions(Driver.get());

        WebElement jobTitle = Driver.get().findElement(By.cssSelector("input#job"));
        actions.click(jobTitle)
                .sendKeys("QA Intern"+ Keys.TAB)
                .sendKeys("KraftTech"+Keys.TAB)
                .sendKeys("İstanbul"+Keys.TAB)
                .sendKeys("11112020"+Keys.TAB+Keys.TAB)
                .sendKeys("12122022"+Keys.TAB)
                .sendKeys("those days were what a nice mentoring time"+Keys.TAB+Keys.ENTER).perform();
    }
}
