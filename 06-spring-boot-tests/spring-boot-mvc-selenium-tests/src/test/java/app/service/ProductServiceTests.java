package app.service;

import app.model.Product;
import app.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("ProductService")
@ExtendWith(MockitoExtension.class)
public class ProductServiceTests {

    @Mock
    transient ProductRepository productRepository;

    @InjectMocks
    transient ProductService productService;

    @Test
    @DisplayName("#findAll returns an array of products")
    void findAll() {
        when(productRepository.findAll()).thenReturn(new ArrayList<>());

        assertThat(productService.findAll()).isEqualTo(new ArrayList<>());
    }

    @Test
    @DisplayName("#findById returns an product")
    void findById() {
        Optional<Product> product = Optional.of(new Product());
        when(productRepository.findById(1)).thenReturn(product);

        assertThat(productService.findById(1)).isInstanceOf(Product.class);
    }

    @Test
    @DisplayName("#create returns a new product")
    void createProduct() {
        when(productRepository.save(any(Product.class))).thenReturn(new Product());

        assertThat(productService.create(new Product())).isInstanceOf(Product.class);
    }

    @Test
    @DisplayName("#update returns an updated product")
    void updateProduct() {
        when(productRepository.save(any(Product.class))).thenReturn(new Product());

        assertThat(productService.update(1, new Product())).isInstanceOf(Product.class);
    }

    @Test
    @DisplayName("#delete deletes the current product")
    void deleteProduct() {
        productService.delete(1);

        verify(productRepository).deleteById(1);
    }
}
