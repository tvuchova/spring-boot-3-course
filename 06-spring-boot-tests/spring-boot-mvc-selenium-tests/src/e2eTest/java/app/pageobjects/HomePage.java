package app.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver browser) {
        PageFactory.initElements(browser, this);
    }

    @FindBy(tagName = "h1")
    public WebElement h1;

    @FindBy(tagName = "a")
    public WebElement addLink;

    @FindBy(css = "tbody > tr")
    public WebElement noResults;

    @FindBy(css = "tbody > tr")
    public WebElement firstRow;

    public WebElement getDetailLink() {
        return firstRow.findElements(By.tagName("a")).get(0);
    }

    public WebElement getEditLink() {
        return firstRow.findElements(By.tagName("a")).get(1);
    }

    public WebElement getDeleteLink() {
        return firstRow.findElements(By.tagName("a")).get(2);
    }
}
