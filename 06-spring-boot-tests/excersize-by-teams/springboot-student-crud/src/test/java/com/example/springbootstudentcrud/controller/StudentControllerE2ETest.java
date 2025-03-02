package com.example.springbootstudentcrud.controller;

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

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentControllerE2ETest {
    private WebDriver driver;
    private WebDriverWait wait;

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
    public void testAddStudent() {
        // go to the "Add Student" page
        driver.get("http://localhost:8080/addstudent");
       //continue the test
    }

    @Test
    public void testViewAllStudents() {
        driver.get("http://localhost:8080/allstudents");

       List<WebElement> studentRows = driver.findElements(By.cssSelector("table tbody tr"));
        assertTrue(studentRows.size() > 0, "No students found in the student list.");
    }

}
