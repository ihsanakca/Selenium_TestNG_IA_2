package com.kraft.tests.day_11;

import com.kraft.pages.DashboardPage;
import com.kraft.pages.LoginPage;
import com.kraft.tests.TestBase;
import com.kraft.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void loginTestWithCR(){
        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();

        loginPage.emailInputBox.sendKeys(ConfigurationReader.get("userEmail"));
        loginPage.passwordInputBox.sendKeys(ConfigurationReader.get("password"));
        loginPage.loginBtn.click();

        String actual = dashboardPage.dashboardPageSubTitle.getText();
        String expected="Dashboard";

        Assert.assertEquals(actual,expected,"FAIL");

    }

    @Test
    public void loginTestWithCR_2(){
        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();

        loginPage.loginMtd();

        String actualUserName = dashboardPage.userName.getText();
        String expectedUserName=ConfigurationReader.get("userName");

        Assert.assertEquals(actualUserName,expectedUserName,"FAIL");
    }

    @Test
    public void loginWithCredentials(){
        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();

        loginPage.loginWithCredentialsMtd("sgezer@gmail.com","sg12345678");

        String actualUserJob = dashboardPage.userJob.getText();
        String expectedUserJob=ConfigurationReader.get("userJob");

        Assert.assertEquals(actualUserJob,expectedUserJob,"FAIL");
    }

    @Test
    public void testAlerts() {
        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();

        loginPage.loginMtd();
        String actualUserName = dashboardPage.userName.getText();
        String expectedUserName=ConfigurationReader.get("userName");

        Assert.assertEquals(actualUserName,expectedUserName,"FAIL");

        dashboardPage.navigateTabAndModule("JavaScript","Alerts");
    }
    @Test
    public void testTabs() {
        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();

        loginPage.loginMtd();
        String actualUserName = dashboardPage.userName.getText();
        String expectedUserName=ConfigurationReader.get("userName");

        Assert.assertEquals(actualUserName,expectedUserName,"FAIL");

        dashboardPage.navigateTabAndModule("Developers");
    }

}
