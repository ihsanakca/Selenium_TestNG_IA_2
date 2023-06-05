package com.kraft.tests.day_15;

import com.kraft.pages.DashboardPage;
import com.kraft.pages.LoginPage;
import com.kraft.tests.TestBase;
import com.kraft.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDF_LoginTest extends TestBase {

    @DataProvider(name="LoginCredentials")
    public Object[][] userData(){
        ExcelUtil qaTeam1 = new ExcelUtil("src/test/resources/LoginList.xlsx", "QaTeam1");
        String[][] dataArray = qaTeam1.getDataArrayWithoutFirstRow();
        return dataArray;
    }

    @Test(dataProvider = "LoginCredentials")
    public void loginTestWithDDF(String yourName,String yourEmail,String password){
        extentLogger=report.createTest("TC005 DDFLoginTest(Excel)");

        LoginPage loginPage=new LoginPage();
        DashboardPage dashboardPage=new DashboardPage();

        extentLogger.info("Navigate to login Page");
        extentLogger.info("login with valid credentials");
        loginPage.loginWithCredentialsMtd(yourEmail,password);

        extentLogger.info("verify that login is successful by using userName: "+yourName);
        String actualName = dashboardPage.userName.getText();
        Assert.assertEquals(actualName,yourName,"verify that both names are same");

        extentLogger.pass("Passed !!");

    }

    @Test(dataProvider = "LoginCredentials")
    public void loginTestWithDDF_2(String yourName,String yourEmail,String password){
        extentLogger=report.createTest("TC005 DDFLoginTest(Excel)");

        LoginPage loginPage=new LoginPage();
        DashboardPage dashboardPage=new DashboardPage();

        extentLogger.info("Navigate to login Page");
        extentLogger.info("login with valid credentials");
        loginPage.loginWithCredentialsMtd(yourEmail,password);

        extentLogger.info("verify that login is successful by using userName: "+yourName);
        String actualName = dashboardPage.userName.getText();
        Assert.assertEquals(actualName,yourName,"verify that both names are same");

        //dashboardPage.logoutAndNavigateToLoginPage(yourName);

        extentLogger.pass("Passed !!");

    }
}
