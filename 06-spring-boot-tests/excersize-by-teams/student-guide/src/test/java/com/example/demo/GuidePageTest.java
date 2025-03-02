package com.example.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GuidePageTest {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @Test
    public void testGuideFormSubmissionWithValidData() {
        driver.get("http://localhost:8080/addguide");
        driver.findElement(By.name("name")).sendKeys("John Doe");
        driver.findElement(By.name("salary")).sendKeys("2000");
        driver.findElement(By.tagName("button")).click();
        wait.until(ExpectedConditions.urlContains("/allstudents"));
        assertEquals("http://localhost:8080/allstudents", driver.getCurrentUrl());
    }

    @Test
    public void testGuideFormValidationError() {
        driver.get("http://localhost:8080/addguide");
        driver.findElement(By.name("name")).sendKeys("12345");
        driver.findElement(By.name("salary")).sendKeys("ddd");
        driver.findElement(By.tagName("button")).click();
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(), 'Only letters allowed.')]")));
        assertTrue(error.isDisplayed());
    }

    @AfterAll
    public static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
