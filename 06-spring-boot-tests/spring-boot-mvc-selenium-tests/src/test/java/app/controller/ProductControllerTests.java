package app.controller;

import app.model.Product;
import app.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.sql.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("ProductController")
@ExtendWith(MockitoExtension.class)
public class ProductControllerTests {

    @Mock
    transient Model model;

    @Mock
    transient ProductService productService;

    @InjectMocks
    transient ProductController productController;

    @Test
    @DisplayName("#index returns the 'index' page")
    void homePage() {
        when(productService.findAll()).thenReturn(List.of());

        assertThat(productController.index(model)).isEqualTo("index");
    }

    @Test
    @DisplayName("#create returns the 'edit' page")
    void addPage() {
        assertThat(productController.create(model)).isEqualTo("edit");
    }

    @Test
    @DisplayName("#create returns the 'detail' page on save")
    void addPagePost() {
        Product product = new Product(1, "Beer", 0.33, "L", 0.5, "€", new Date(System.currentTimeMillis()));
        when(productService.create(product)).thenReturn(product);

        assertThat(productController.create(product, model)).isEqualTo("redirect:/detail/1");
    }

    @Test
    @DisplayName("#detail returns the 'detail' page")
    void detailPage() {
        when(productService.findById(1)).thenReturn(new Product());

        assertThat(productController.detail(1, model)).isEqualTo("detail");
    }

    @Test
    @DisplayName("#update returns the 'edit' page")
    void editPage() {
        when(productService.findById(1)).thenReturn(new Product());

        assertThat(productController.update(1, model)).isEqualTo("edit");
    }

    @Test
    @DisplayName("#update returns the 'detail' page on save")
    void editPagePost() {
        Product product = new Product(1, "Beer", 0.33, "L", 0.5, "€", new Date(System.currentTimeMillis()));
        when(productService.update(1, product)).thenReturn(product);

        assertThat(productController.update(1, product)).isEqualTo("redirect:/detail/1");
    }

    @Test
    @DisplayName("#delete returns the 'delete' page")
    void deletePage() {
        when(productService.findById(1)).thenReturn(new Product());

        assertThat(productController.delete(1, model)).isEqualTo("delete");
    }

    @Test
    @DisplayName("#delete returns the 'index' page on delete")
    void deletePagePost() {
        assertThat(productController.delete(1)).isEqualTo("redirect:/");
        verify(productService).delete(1);
    }
}
