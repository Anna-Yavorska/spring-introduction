package javahome.springbootstudent.hw_41.service;

import javahome.springbootstudent.hw_41.controller.dto.ProductDTO;
import javahome.springbootstudent.hw_41.controller.dto.ProductFilterDTO;


import java.util.Collection;
import java.util.List;

public interface ProductService {
    ProductDTO getProductById(Integer id);

    Collection<ProductDTO> getAllProducts();

    void deleteProduct(Integer id);

    Integer createProduct(ProductDTO productToCreate);

    ProductDTO updateProduct(Integer id, ProductDTO productToUpdate);

    List<ProductDTO> search(ProductFilterDTO filter);
}
