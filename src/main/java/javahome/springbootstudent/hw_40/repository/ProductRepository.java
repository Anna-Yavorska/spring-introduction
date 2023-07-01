package javahome.springbootstudent.hw_40.repository;

import javahome.springbootstudent.hw_40.repository.model.Product;

import java.util.Collection;
import java.util.List;

public interface ProductRepository {
    Product getProductById(Integer id);

    Collection<Product> getAllProducts();

    void deleteProduct(Integer id);

    Integer createProduct(Product productToCreate);

    List<Product> searchByDescription(String description);

}
