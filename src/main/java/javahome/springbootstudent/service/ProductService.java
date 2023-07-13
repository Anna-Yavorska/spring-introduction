package javahome.springbootstudent.service;

import javahome.springbootstudent.controller.dto.ProductDTO;
import javahome.springbootstudent.controller.dto.ProductFilterDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Collection;
import java.util.List;

public interface ProductService {
    ProductDTO getProductById(Integer id);

    Collection<ProductDTO> getAllProducts();

    void deleteProduct(Integer id);

    Integer createProduct(ProductDTO productToCreate);

    ProductDTO updateProduct(Integer id, ProductDTO productToUpdate);

    List<ProductDTO> search(ProductFilterDTO filter);

    Page<ProductDTO> getPage(Pageable pageable);
}
