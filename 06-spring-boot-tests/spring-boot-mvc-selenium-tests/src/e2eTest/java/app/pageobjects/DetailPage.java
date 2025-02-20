package app.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailPage {
    
    public DetailPage(WebDriver browser) {
        PageFactory.initElements(browser, this);
    }

    @FindBy(tagName = "h1")
    public WebElement h1;

}
