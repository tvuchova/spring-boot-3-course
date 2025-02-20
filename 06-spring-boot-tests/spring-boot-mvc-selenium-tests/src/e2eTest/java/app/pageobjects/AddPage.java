package app.pageobjects;

import app.model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;

public class AddPage {

    public AddPage(WebDriver browser) {
        PageFactory.initElements(browser, this);
    }

    @FindBy(tagName = "h1")
    public WebElement h1;

    @FindBy(tagName = "form")
    public WebElement form;

    @FindBy(tagName = "button")
    public WebElement submit;

    public WebElement getName() {
        return form.findElements(By.tagName("input")).get(0);
    }

    public WebElement getQuantity() {
        return form.findElements(By.tagName("input")).get(1);
    }

    public WebElement getUnit() {
        return form.findElements(By.tagName("input")).get(2);
    }

    public WebElement getPrice() {
        return form.findElements(By.tagName("input")).get(3);
    }

    public WebElement getCurrency() {
        return form.findElements(By.tagName("input")).get(4);
    }

    public WebElement getExpirationDate() {
        return form.findElements(By.tagName("input")).get(5);
    }

    public void fillFormWithProduct(Product product) {
        getName().sendKeys(product.getName());
        getQuantity().sendKeys(product.getQuantity().toString());
        getUnit().sendKeys(product.getUnit());
        getPrice().sendKeys(product.getPrice().toString());
        getCurrency().sendKeys(product.getCurrency());
        getExpirationDate().sendKeys(new SimpleDateFormat("MM/dd/yyyy").format(product.getExpirationDate()));
    }
}
