package javahome.springbootstudent.controller;

import jakarta.validation.Valid;
import javahome.springbootstudent.controller.dto.ProductDTO;
import javahome.springbootstudent.controller.dto.ProductFilterDTO;
import javahome.springbootstudent.converter.ProductConverter;
import javahome.springbootstudent.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductConverter.class);

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Integer id) {
        LOGGER.warn("User can enter non-exists id");
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
    public Integer createProduct(@RequestBody @Valid ProductDTO productToCreate) {
        return productService.createProduct(productToCreate);
    }

    @PutMapping("/{id}")
    public ProductDTO update(@PathVariable Integer id, @RequestBody @Valid ProductDTO productToUpdate) {
        LOGGER.debug(String.format("Updating product with id %s", id));
        return productService.updateProduct(id, productToUpdate);
    }

    @PostMapping("/search")
    public List<ProductDTO> search(@RequestBody ProductFilterDTO filter) {
        return productService.search(filter);
    }

    @GetMapping("/page")
    public Page<ProductDTO> getPages(Pageable pageable) {
        LOGGER.trace("Request to products by pages");
        return productService.getPage(pageable);
    }
}
