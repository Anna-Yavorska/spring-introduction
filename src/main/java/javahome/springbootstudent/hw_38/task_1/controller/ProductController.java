package javahome.springbootstudent.hw_38.task_1;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return productRepository.getProductById(id);
    }

    @GetMapping
    public Collection<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        return productRepository.deleteProduct(id);
    }
}