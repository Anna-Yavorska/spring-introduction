package javahome.springbootstudent.hw_40.service;

import javahome.springbootstudent.hw_40.controller.dto.ProductDTO;
import javahome.springbootstudent.hw_40.repository.model.Product;

import java.util.Collection;
import java.util.List;

public interface ProductService {
    ProductDTO getProductById(Integer id);

    Collection<ProductDTO> getAllProducts();

    void deleteProduct(Integer id);

    Integer createProduct(ProductDTO productToCreate);

    List<ProductDTO> searchByDescription(String description);
}
