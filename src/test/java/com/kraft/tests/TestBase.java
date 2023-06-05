package com.kraft.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.kraft.utilities.BrowserUtils;
import com.kraft.utilities.ConfigurationReader;
import com.kraft.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    static protected ExtentReports report;

    protected ExtentHtmlReporter htmlReporter;

    protected ExtentTest extentLogger;


    @BeforeTest
    public void setUpTest() {
        //classı çağıralım
        report = new ExtentReports();

        //rapor pathi oluşturalım

        String projectPath = System.getProperty("user.dir");
        String reportPath = projectPath + "/test-output/report.html";
        //String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        //String reportPath=projectPath + "/test-output/report"+date+".html";

        //HTML raporumuzu path ile oluşturalım
        htmlReporter = new ExtentHtmlReporter(reportPath);

        //HTML raporumuzu report nesnesiyle ilişkilendirelim.,
        report.attachReporter(htmlReporter);

        //rapor başlığını düzenleyelim
        htmlReporter.config().setReportName("Deneme Testi");

        //rapor alan (enviroment) adlarını düzenleyelim

        report.setSystemInfo("Enviroment", "UAT");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));
        report.setSystemInfo("Test Specialist", "IhsanUmut");
    }

    @AfterTest
    public void tearDownTest() {
        //rapor tam olarak bu kod ile oluşturulur.
        report.flush();
        //Driver.closeDriver();
    }

    @BeforeMethod
    public void setUp() {
        driver = Driver.get();
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.get("url"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, 10);
        js = (JavascriptExecutor) driver;

    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        //Eğer test başarılı olmazsa
        if (result.getStatus() == ITestResult.FAILURE) {
            //başarısız testin adını alalım
            extentLogger.fail(result.getName());
            //ekran görüntüsü (screen shot) alalım ve ekran görüntüsünün kayıt edileceği yeri belrleyelim
            String screenShotPath = BrowserUtils.getScreenshot(result.getName());
            //ekran görüntüsünü rapora ekleyelim
            extentLogger.addScreenCaptureFromPath(screenShotPath);
            //hata logunu (exception logs) raporun içine koyalım
            extentLogger.fail(result.getThrowable());
        }

        Driver.closeDriver();
    }


}
