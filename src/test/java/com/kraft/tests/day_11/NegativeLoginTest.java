package com.kraft.tests.day_11;

import com.kraft.pages.LoginPage;
import com.kraft.tests.TestBase;
import com.kraft.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    @Test
    public void wrongUserEmailTest(){
        LoginPage loginPage=new LoginPage();

        loginPage.emailInputBox.sendKeys("blabla@aaa.com");
        loginPage.passwordInputBox.sendKeys(ConfigurationReader.get("password"));
        loginPage.loginBtn.click();

        Assert.assertTrue(loginPage.emailWarningMessage.getText().contains("Email address is incorrect. Please check"));
    }

    @Test
    public void wrongPasswordTest(){
        LoginPage loginPage=new LoginPage();

        loginPage.emailInputBox.sendKeys(ConfigurationReader.get("userEmail"));
        loginPage.passwordInputBox.sendKeys("somepassword");
        loginPage.loginBtn.click();

        Assert.assertTrue(loginPage.passwordWarningMessage.getText().contains("Password is incorrect. Please check"));
    }
}
