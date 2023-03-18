package com.kraft.tests.day_12;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.kraft.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentReportDemo {

    ExtentReports report;

    ExtentHtmlReporter htmlReporter;

    ExtentTest extentLogger;


    @BeforeMethod
    public void setUp(){

        //classı çağıralım
        report=new ExtentReports();

        //rapor pathi oluşturalım

        String projectPath=System.getProperty("user.dir");
        String reportPath=projectPath+"/test-output/report.html";

        //HTML raporumuzu path ile oluşturalım
        htmlReporter=new ExtentHtmlReporter(reportPath);

        //HTML raporumuzu report nesnesiyle ilişkilendirelim.,
        report.attachReporter(htmlReporter);

        //rapor başlığını düzenleyelim
        htmlReporter.config().setReportName("Deneme Testi");

        //rapor alan (enviroment) adlarını düzenleyelim

        report.setSystemInfo("Enviroment","UAT");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
        report.setSystemInfo("Test Specialist","IhsanUmut");

    }

    @Test
    public void demoExtentReportTest() {
        //mevcut testin ismini düzenleyelim
        extentLogger=report.createTest("TC001_DemoExtentTest");

        //test adımlarını
        extentLogger.info("Chrome browserı aç");
        extentLogger.info("Web sitesine git"+ConfigurationReader.get("url"));
        extentLogger.info("Emaili ilgili alana gir");
        extentLogger.info("Şifreyi ilgili alana gir");
        extentLogger.info("Login düğmesine bas");
        extentLogger.info("Siteye giriş yaptığını kullanıcı adı "+ConfigurationReader.get("userName")+" ile doğrula");

        extentLogger.pass("PASSED");
    }

    @AfterMethod
    public void tearDown() {
        //rapor tam olarak bu kod ile oluşturulur.
        report.flush();

    }
}
