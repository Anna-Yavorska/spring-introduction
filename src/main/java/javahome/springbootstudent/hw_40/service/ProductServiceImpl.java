package javahome.springbootstudent.hw_40.service;

import javahome.springbootstudent.hw_40.controller.dto.ProductDTO;
import javahome.springbootstudent.hw_40.converter.ProductConverter;
import javahome.springbootstudent.hw_40.repository.ProductRepository;
import javahome.springbootstudent.hw_40.repository.model.Product;
import javahome.springbootstudent.hw_40.validator.ProductValidator;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductConverter productConverter;
    private final ProductValidator productValidator;

    public ProductServiceImpl(ProductRepository productRepository, ProductConverter productConverter, ProductValidator productValidator) {
        this.productRepository = productRepository;
        this.productConverter = productConverter;
        this.productValidator = productValidator;
    }

    @Override
    public ProductDTO getProductById(Integer id) {
        return productConverter.convertToProductDto(productRepository.getProductById(id));
    }

    @Override
    public Collection<ProductDTO> getAllProducts() {
        return productConverter.convertToProductDTO(productRepository.getAllProducts());
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteProduct(id);
    }

    @Override
    public Integer createProduct(ProductDTO productToCreate) {
        productValidator.validateProduct(productToCreate);
        Product product = productConverter.convertToEntity(productToCreate);
        return productRepository.createProduct(product);
    }

    @Override
    public List<ProductDTO> searchByDescription(String description) {
        List<Product> products = productRepository.searchByDescription(description);
        return productConverter.convertToProductDTO(products);
    }
}
