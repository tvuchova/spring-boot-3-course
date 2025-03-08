package com.mnb.selenium;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryManagementTests {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLoginPageLoads() {
        driver.get("http://localhost:8080/login");

        WebElement loginForm = driver.findElement(By.tagName("form"));
        assertTrue(loginForm.isDisplayed());
    }

    @Test
    public void testUserCanLogin() {
        driver.get("http://localhost:8080/login");

        // Enter username and password
        driver.findElement(By.name("username")).sendKeys("merve");
        driver.findElement(By.name("password")).sendKeys("test123");

        driver.findElement(By.tagName("form")).submit();

        assertEquals("http://localhost:8080/", driver.getCurrentUrl());
    }

    @Test
    public void testNavigationToBooksPage() {
        driver.get("http://localhost:8080/");
        driver.findElement(By.name("username")).sendKeys("merve");
        driver.findElement(By.name("password")).sendKeys("test123");

        // Submit
        driver.findElement(By.tagName("form")).submit();

        // Click on "Books"
        driver.findElement(By.xpath("//a[contains(text(), 'BOOKS')]")).click();

        assertEquals("http://localhost:8080/books/list", driver.getCurrentUrl());
    }

}
