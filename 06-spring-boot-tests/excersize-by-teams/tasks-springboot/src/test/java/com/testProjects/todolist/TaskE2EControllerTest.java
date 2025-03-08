package com.testProjects.todolist;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskE2EControllerTest {
    private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //see how to delete user or generate different users
        signupUser();
    }

    @Test
    public void testCreateTask() {
        login();

        driver.get("http://localhost:8080/tasks/create");

        // Fill in task details
        WebElement titleInput = driver.findElement(By.id("title"));
        WebElement descriptionInput = driver.findElement(By.id("description"));
        WebElement createButton = driver.findElement(By.cssSelector("button[type='submit']"));

        titleInput.sendKeys("New Task");
        descriptionInput.sendKeys("This is a test task.");
        createButton.click();

        // check if the task is created
        String currentUrl = driver.getCurrentUrl();
    }


    @Test
    public void testDeleteTask() {

        login();

        driver.get("http://localhost:8080");

        WebElement deleteButton = driver.findElement(By.cssSelector("button[type='submit']"));
        deleteButton.click();

        WebElement taskList = driver.findElement(By.cssSelector("table"));
        assertFalse(taskList.getText().contains("Task Title"), "Task should be deleted from task list");
    }

    private void login() {
        driver.get("http://localhost:8080/signin");
        WebElement usernameInput = driver.findElement(By.name("username"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

        usernameInput.sendKeys("testuser2");
        passwordInput.sendKeys("password1234");
        loginButton.click();
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void signupUser() {
        driver.get("http://localhost:8080/signup");


        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement confirmPasswordInput = driver.findElement(By.id("confirmPassword"));
        WebElement signupButton = driver.findElement(By.cssSelector("button[type='submit']"));

        usernameInput.sendKeys("testuser2");
        passwordInput.sendKeys("password1234");
        confirmPasswordInput.sendKeys("password1234");
        signupButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/signin"));
    }

}
