package JavaRestMaster;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
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

/*    @BeforeAll
    public static void setupClass() {
        // Set up WebDriverManager to automatically manage the ChromeDriver
        WebDriverManager.chromedriver().setup();
    }*/

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testAddStudent() {
       //add test for adding student
    }

    @Test
    public void testViewStudentList() {
        driver.get("http://localhost:8080/students");

        List<WebElement> studentRows = driver.findElements(By.cssSelector("table tbody tr"));
        assertTrue(studentRows.size() > 0, "No students found in the student list.");
    }

    @Test
    public void testViewCoursesForStudent() {
        driver.get("http://localhost:8080/students/1/courses");

        WebElement addCourseButton = driver.findElement(By.xpath("//a[contains(text(), 'Add Courses')]"));
        assertTrue(addCourseButton.isDisplayed(), "Add Courses button should be visible.");
    }

    @Test
    public void testAddCourseToStudent() {
     //add test
    }

    @Test
    public void testRemoveCourseFromStudent() {
    //add test
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
