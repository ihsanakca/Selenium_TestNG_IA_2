package com.kraft.tests.day_13;

import com.kraft.pages.AddEducationPage;
import com.kraft.pages.DashboardPage;
import com.kraft.pages.LoginPage;
import com.kraft.pages.OverviewPage;
import com.kraft.tests.TestBase;
import com.kraft.utilities.BrowserUtils;
import com.kraft.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddNewEducationTest extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    OverviewPage overviewPage;
    AddEducationPage addEducationPage;

    @Test
    public void addEducationTest_2(){
        /**
        1-open chrome browser
        2-navigate to https://www.krafttechexlab.com/login by using configuration.properties
        3-login with parameterized login method
        4-Assert successful login with user name
        5-Navigate to My Profile with related method
        6-Verify that overview page is displayed
        7-Navigate to Add Education tab with related method
        8-Verify that add education page is displayed
        9-Fill the form with parameterized login method (using actions class is optional)
        10-Verify that added education information can be seen at overview page...

        important note: every student should use own credentials, otherwise the test case will fail....
*/
        extentLogger = report.createTest("TC003 Adding New Education");

        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();
        overviewPage=new OverviewPage();
        addEducationPage=new AddEducationPage();

        extentLogger.info("Navigate to "+ ConfigurationReader.get("url"));
        extentLogger.info("Login the site with correct userEmail and password");
        loginPage.loginWithCredentialsMtd(ConfigurationReader.get("userEmail"),ConfigurationReader.get("password"));

        extentLogger.info("verify that login is successful with user name= "+ConfigurationReader.get("userName"));
        BrowserUtils.waitForVisibility(dashboardPage.userName,5);
        String actualJob = dashboardPage.userName.getText();
        String expectedJob=ConfigurationReader.get("userName");
        Assert.assertEquals(actualJob,expectedJob,"should be same");

        extentLogger.info("click to my profile button");
        dashboardPage.navigateTabAndModule(ConfigurationReader.get("userName"),"My Profile");

        extentLogger.info("Verify that overview page displayed");
        BrowserUtils.waitForVisibility(overviewPage.overviewPageSubTitle,5);
        Assert.assertTrue(overviewPage.overviewPageSubTitle.isDisplayed());

        extentLogger.info("navigate to Add Education tab");
        overviewPage.navigateUserProfileTabs("Add Education");

        extentLogger.info("Verify that add education page displayed");
        BrowserUtils.waitForVisibility(addEducationPage.addEducationBtn,5);
        Assert.assertTrue(addEducationPage.addEducationBtn.isDisplayed());

        extentLogger.info("adding new education record");
        addEducationPage.addEducationMtd("Gazi University","Good Degree","Finance",
                "11122018","12122021","Very nice education");

        extentLogger.info("verify that last added education record is displayed on overview page");
        String expectedUserSchoolName="Gazi University";
        String actualUserSchoolName=overviewPage.addedEducationName("Gazi University");
        Assert.assertEquals(actualUserSchoolName,expectedUserSchoolName,"should be same");

        extentLogger.info("delete last added education");
        overviewPage.deleteEducation(overviewPage.addedEducationName("Gazi University"));

        extentLogger.pass("PASSED");

    }
}
