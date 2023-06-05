package com.kraft.tests.day_15;

import com.kraft.pages.AddEducationPage;
import com.kraft.pages.DashboardPage;
import com.kraft.pages.LoginPage;
import com.kraft.pages.OverviewPage;
import com.kraft.tests.TestBase;
import com.kraft.utilities.BrowserUtils;
import com.kraft.utilities.ConfigurationReader;
import com.kraft.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDF_AddEducationTest extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    OverviewPage overviewPage;
    AddEducationPage addEducationPage;

    @DataProvider
    public Object[][] educationData(){
        ExcelUtil qaTeam3 = new ExcelUtil("src/test/resources/LoginList.xlsx", "QaTeam3");
        String[][] dataArray = qaTeam3.getDataArrayWithoutFirstRow();
        return dataArray;
    }

    @Test(dataProvider = "educationData")
    public void addEducationTestWithDDF(String email, String password,String userName,String school,
                                        String degree,String study,String fromDate,String toDate,String description){

        extentLogger = report.createTest("TC004 Adding New Education");

        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();
        overviewPage=new OverviewPage();
        addEducationPage=new AddEducationPage();

        extentLogger.info("Navigate to "+ ConfigurationReader.get("url"));
        extentLogger.info("Login the site with correct userEmail and password");
        loginPage.loginWithCredentialsMtd(email,password);

        extentLogger.info("verify that login is successful with user name= "+userName);
        BrowserUtils.waitForVisibility(dashboardPage.userName,5);
        String actualJob = dashboardPage.userName.getText();
        String expectedJob=userName;
        Assert.assertEquals(actualJob,expectedJob,"should be same");

        extentLogger.info("click to my profile button");
        dashboardPage.navigateTabAndModule(userName,"My Profile");

        extentLogger.info("Verify that overview page displayed");
        BrowserUtils.waitForVisibility(overviewPage.overviewPageSubTitle,5);
        Assert.assertTrue(overviewPage.overviewPageSubTitle.isDisplayed());

        extentLogger.info("navigate to Add Education tab");
        overviewPage.navigateUserProfileTabs("Add Education");

        extentLogger.info("Verify that add education page displayed");
        BrowserUtils.waitForVisibility(addEducationPage.addEducationBtn,5);
        Assert.assertTrue(addEducationPage.addEducationBtn.isDisplayed());

        extentLogger.info("adding new education record");
        addEducationPage.addEducationMtd(school,degree,study,fromDate,toDate,description);

        extentLogger.info("verify that last added education record is displayed on overview page");
        String expectedUserSchoolName=school;
        String actualUserSchoolName=overviewPage.addedEducationName(school);
        Assert.assertEquals(actualUserSchoolName,expectedUserSchoolName,"should be same");

        extentLogger.info("delete last added education by school name: "+school);
        overviewPage.deleteEducation(overviewPage.addedEducationName(school));

        extentLogger.pass("PASSED");

    }
}
