package com.example.thymeleaf;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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

public class IndexE2eTests {
    private WebDriver driver;
    private static WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testIndexRedirectsToStudents() {
        driver.get("http://localhost:8080/");
        wait.until(ExpectedConditions.urlContains("/students"));
        assertEquals("http://localhost:8080/students", driver.getCurrentUrl());
    }

    @Test
    public void testStudentsPageLoads() {
        driver.get("http://localhost:8080/students");
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        assertEquals("Students Repository", title.getText());
    }

    @Test
    public void testRecordsFound() {
        driver.get("http://localhost:8080/students");
       WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
    }

}
