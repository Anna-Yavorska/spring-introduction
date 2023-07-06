package javahome.springbootstudent.hw_41.controller;

import javahome.springbootstudent.hw_41.controller.dto.ProductFilterDTO;
import javahome.springbootstudent.hw_41.controller.dto.ProductDTO;
import javahome.springbootstudent.hw_41.service.ProductService;
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

    @PutMapping("/{id}")
    public ProductDTO update(@PathVariable Integer id, @RequestBody ProductDTO productToUpdate) {
        return productService.updateProduct(id, productToUpdate);
    }

    @PostMapping("/search")
    public List<ProductDTO> search(@RequestBody ProductFilterDTO filter) {
        return productService.search(filter);
    }
}
