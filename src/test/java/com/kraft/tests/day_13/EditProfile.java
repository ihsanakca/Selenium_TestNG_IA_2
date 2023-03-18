package com.kraft.tests.day_13;

import com.kraft.pages.*;
import com.kraft.tests.TestBase;
import com.kraft.utilities.BrowserUtils;
import com.kraft.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditProfile extends TestBase {
    @Test
    public void addExperienceTest() {
        extentLogger = report.createTest("TC001 Adding New Experience");

        LoginPage loginPage=new LoginPage();
        DashboardPage dashboardPage=new DashboardPage();
        OverviewPage overviewPage=new OverviewPage();
        AddExperiencePage addExperiencePage=new AddExperiencePage();

        extentLogger.info("Navigate to "+ ConfigurationReader.get("url"));
        extentLogger.info("Enter site with correct userEmail and password");
        loginPage.loginMtd();

        extentLogger.info("verify that login is successful with account name= "+ConfigurationReader.get("userName"));
        String expectedUserName=ConfigurationReader.get("userName");
        String actualUserName=dashboardPage.userName.getText();
        Assert.assertEquals(actualUserName,expectedUserName);

        extentLogger.info("click to my profile button");
        dashboardPage.navigateTabAndModule(ConfigurationReader.get("userName"),"My Profile");

        BrowserUtils.waitFor(2);

        extentLogger.info("navigate to Add Experience tab");
        overviewPage.navigateUserProfileTabs("Add Experience");

        extentLogger.info("adding new experience");
        addExperiencePage.addExperienceMtd();

        BrowserUtils.waitFor(2);

        extentLogger.pass("PASSED");

    }

    @Test
    public void addEducationTest() {
        extentLogger = report.createTest("TC002 Adding New Education");

        LoginPage loginPage=new LoginPage();
        DashboardPage dashboardPage=new DashboardPage();
        OverviewPage overviewPage=new OverviewPage();
        AddEducationPage addEducationPage=new AddEducationPage();

        extentLogger.info("Navigate to "+ ConfigurationReader.get("url"));
        extentLogger.info("Enter site with correct userEmail and password");
        loginPage.loginWithCredentialsMtd(ConfigurationReader.get("userEmail"),ConfigurationReader.get("password"));

        extentLogger.info("verify that login is successful with user job= "+ConfigurationReader.get("userJob"));
        String actualJob = dashboardPage.userJob.getText();
        String expectedJob=ConfigurationReader.get("userJob");
        Assert.assertEquals(actualJob,expectedJob,"should be same");

        extentLogger.info("click to my profile button");
        dashboardPage.navigateTabAndModule(ConfigurationReader.get("userName"),"My Profile");

        extentLogger.info("navigate to Add Education tab");
        overviewPage.navigateUserProfileTabs("Add Education");

        extentLogger.info("adding new education");
        addEducationPage.addEducationMtd("KraftTech","Master Degree","Tester",
                "11122018","12122021","Nice Course");

        extentLogger.pass("PASSED");

        BrowserUtils.waitFor(2);
    }
}
