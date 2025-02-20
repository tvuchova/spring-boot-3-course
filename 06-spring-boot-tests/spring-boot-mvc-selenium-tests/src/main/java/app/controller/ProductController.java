package app.controller;

import app.model.Product;
import app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private transient ProductService productService;

    @GetMapping
    public String index(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);

        return "index";
    }

    @GetMapping("add")
    public String create(Model model) {
        model.addAttribute("product", new Product());

        return "edit";
    }

    @PostMapping("add")
    public String create(@Validated Product product, Model model) {
        Product newProduct = productService.create(product);

        return "redirect:/detail/" + newProduct.getId();
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);

        return "detail";
    }

    @GetMapping("edit/{id}")
    public String update(@PathVariable Integer id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);

        return "edit";
    }

    @PostMapping("edit/{id}")
    public String update(@PathVariable Integer id, @Validated Product product) {
        Product updatedProduct = productService.update(id, product);

        return "redirect:/detail/" + updatedProduct.getId();
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);

        return "delete";
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        productService.delete(id);

        return "redirect:/";
    }
}
