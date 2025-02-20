package app.tests;

import app.E2E;
import app.model.Product;
import app.pageobjects.AddPage;
import app.pageobjects.DetailPage;
import app.pageobjects.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.sql.Date;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Application")
@TestMethodOrder(OrderAnnotation.class)
public class ApplicationE2ETests extends E2E {

    private AddPage addPage;

    private DetailPage detailPage;

    private HomePage homePage;

    @BeforeEach
    void beforeEach() {
        addPage = new AddPage(browser);
        detailPage = new DetailPage(browser);
        homePage = new HomePage(browser);
        browser.get(baseUrl);
    }

    @Test
    @Order(1)
    @DisplayName("I see 'No results found!' label when I open the Home Page")
    void homePageNoResults() {
        assertThat(browser.getTitle()).isEqualTo("Spring App");
        assertThat(homePage.h1.getText()).isEqualTo("List of Products");
        assertThat(homePage.noResults.getText()).isEqualTo("No results found!");
    }

    @Test
    @Order(2)
    @DisplayName("I see 'Add Product' when I click on the 'Add Product' link")
    void titleOfAddPage() {
        homePage.addLink.click();

        assertThat(addPage.h1.getText()).isEqualTo("Add Product");
    }

    @Test
    @Order(3)
    @DisplayName("I want to add a new Product and see its details page")
    void addNewProduct() {
        homePage.addLink.click();
        addPage.fillFormWithProduct(new Product(-1, "Beer", 0.33, "L", 0.5, "€", new Date(1642523079644L)));
        addPage.submit.click();

        assertThat(detailPage.h1.getText()).isEqualTo("Product Details");
    }

    @Test
    @Order(4)
    @DisplayName("I see 'Product Details' when I click on the 'Details' link for the first Product")
    void detailPage() {
        homePage.getDetailLink().click();

        assertThat(detailPage.h1.getText()).isEqualTo("Product Details");
    }

    @Test
    @Order(5)
    @DisplayName("I see 'Edit Product' when I click on the 'Edit' link for the first Product")
    void editPage() {
        homePage.getEditLink().click();

        assertThat(addPage.h1.getText()).isEqualTo("Edit Product");
    }

    @Test
    @Order(6)
    @DisplayName("I see 'Delete Product Beer' when I click on the 'Delete' link for the first Product")
    void deletePage() {
        homePage.getDeleteLink().click();

        assertThat(homePage.h1.getText()).isEqualTo("Delete Product Beer");
    }
}
