package javahome.springbootstudent.hw_40.controller;

import javahome.springbootstudent.hw_40.controller.dto.ProductDTO;
import javahome.springbootstudent.hw_40.repository.model.Product;
import javahome.springbootstudent.hw_40.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    @GetMapping
    public Collection<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }

    @PostMapping
    public Integer createProduct(@RequestBody ProductDTO productToCreate) {
        return productService.createProduct(productToCreate);
    }

    @GetMapping("/description")
    public List<ProductDTO> searchByDescription(@RequestParam String description) {
        return productService.searchByDescription(description);
    }
}
