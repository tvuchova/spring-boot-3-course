package app;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.wait.strategy.Wait;

@ActiveProfiles("test")
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public abstract class E2E {

    protected static WebDriver browser;

    protected final String baseUrl = "http://localhost:8080";

    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres");

    static {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        postgres.withExposedPorts(5432)
                .withDatabaseName("test")
                .withUsername("test")
                .withPassword("test")
                .withReuse(true)
                .waitingFor(Wait.forListeningPort())
                .start();
    }

    @DynamicPropertySource
    static void setDatasourceProperties(DynamicPropertyRegistry propertyRegistry) {
        propertyRegistry.add("spring.datasource.url", postgres::getJdbcUrl);
        propertyRegistry.add("spring.datasource.password", postgres::getPassword);
        propertyRegistry.add("spring.datasource.username", postgres::getUsername);
    }

    @BeforeAll
    static void beforeAll() {
        browser = new ChromeDriver(new ChromeOptions().addArguments("--headless"));
    }

    @AfterAll
    static void afterAll() {
        browser.quit();
    }
}
