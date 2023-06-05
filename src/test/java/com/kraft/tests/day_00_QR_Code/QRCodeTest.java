package com.kraft.tests.day_00_QR_Code;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.kraft.pages.DashboardPage;
import com.kraft.pages.LoginPage;
import com.kraft.utilities.BrowserUtils;
import com.kraft.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class QRCodeTest {
    WebDriver driver;
    @Test
    public void test1() throws IOException, NotFoundException {

        driver= Driver.get();
        driver.get("https://goqr.me/");
        String urlText="https://www.krafttechexlab.com/login";

        WebElement textArea = driver.findElement(By.cssSelector("#qrcode-field-text-text"));

        textArea.sendKeys(urlText);

        BrowserUtils.waitFor(3);

        String qrCodeUrl = driver.findElement(By.id("qrcode-preview-image")).getAttribute("src");

        URL url=new URL(qrCodeUrl);

        BufferedImage bufferedImage= ImageIO.read(url);

        LuminanceSource luminanceSource=new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap binaryBitmap=new BinaryBitmap(new HybridBinarizer(luminanceSource));

        Result result=new MultiFormatReader().decode(binaryBitmap);
        String resultText = result.getText();

        System.out.println("resultText = " + resultText);

        driver.get(resultText);
        BrowserUtils.waitFor(1);
        LoginPage loginPage=new LoginPage();
        loginPage.loginMtd();

        DashboardPage dashboardPage=new DashboardPage();
        String actualText = dashboardPage.dashboardPageSubTitle.getText();

        String expectedText="Dashboard";
        BrowserUtils.waitFor(2);
        Assert.assertEquals(actualText,expectedText);

        driver.quit();
    }
}
