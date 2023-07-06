package javahome.springbootstudent.hw_41.service;

import javahome.springbootstudent.hw_41.controller.dto.ProductFilterDTO;
import org.springframework.transaction.annotation.Transactional;
import javahome.springbootstudent.hw_41.controller.dto.ProductDTO;
import javahome.springbootstudent.hw_41.converter.ProductConverter;
import javahome.springbootstudent.hw_41.repository.SpringDataProductRepository;
import javahome.springbootstudent.hw_41.repository.model.Product;
import javahome.springbootstudent.hw_41.validator.ProductValidator;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final SpringDataProductRepository productRepository;
    private final ProductConverter productConverter;
    private final ProductValidator productValidator;

    public ProductServiceImpl(SpringDataProductRepository springDataSourceProductRepository, ProductConverter productConverter, ProductValidator productValidator) {
        this.productRepository = springDataSourceProductRepository;
        this.productConverter = productConverter;
        this.productValidator = productValidator;
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDTO getProductById(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found: " + id));
        return productConverter.convertToProductDTO(product);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<ProductDTO> getAllProducts() {
        return productConverter.convertToProductDTO(productRepository.findAll());
    }

    @Override
    @Transactional
    public void deleteProduct(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found: " + id));
        productRepository.delete(product);
    }

    @Override
    @Transactional
    public Integer createProduct(ProductDTO productToCreate) {
        productValidator.validateProduct(productToCreate);
        Product product = productConverter.convertToEntity(productToCreate);
        Product savedProduct = productRepository.save(product);
        return savedProduct.getId();
    }

    @Override
    @Transactional
    public ProductDTO updateProduct(Integer id, ProductDTO productToUpdate) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found: " + id));
        Product entityToUpdate = productConverter.convertToEntity(productToUpdate);
        entityToUpdate.setId(id);
        Product updatedEntity = productRepository.save(entityToUpdate);
        return productConverter.convertToProductDTO(updatedEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> search(ProductFilterDTO filter) {
        String nameLike = "%" + filter.getName() + "%";
        String descriptionLike = "%" + filter.getDescription() + "%";
        List<Product> allByNameOrDescription = productRepository.findAllByNameLikeOrDescriptionLike(nameLike, descriptionLike);
        return productConverter.convertToProductDTO(allByNameOrDescription);
    }

}
