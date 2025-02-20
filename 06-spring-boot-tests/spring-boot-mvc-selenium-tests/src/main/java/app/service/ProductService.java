package app.service;

import app.model.Product;
import app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private transient ProductRepository productRepository;


    public List<Product> findAll() {
        return productRepository.findAll();
    }


    public Product findById(Integer id) {
        return productRepository.findById(id).orElseThrow();
    }


    public Product create(Product product) {
        return productRepository.save(product);
    }


    public Product update(Integer id, Product product) {
        return productRepository.save(product);
    }


    public void delete(Integer id) {
        productRepository.deleteById(id);
    }
}
