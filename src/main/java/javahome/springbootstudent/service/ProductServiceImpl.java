package javahome.springbootstudent.service;

import javahome.springbootstudent.controller.dto.ProductFilterDTO;
import javahome.springbootstudent.exception.NotFoundException;
import javahome.springbootstudent.repository.PagingProductRepository;
import javahome.springbootstudent.validator.ProductValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import javahome.springbootstudent.controller.dto.ProductDTO;
import javahome.springbootstudent.converter.ProductConverter;
import javahome.springbootstudent.repository.SpringDataProductRepository;
import javahome.springbootstudent.repository.model.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final SpringDataProductRepository productRepository;
    private final ProductConverter productConverter;
    private final PagingProductRepository pagingProductRepository;
    private final ProductValidator validator;

    public ProductServiceImpl(SpringDataProductRepository springDataSourceProductRepository, ProductConverter productConverter, PagingProductRepository pagingProductRepository, ProductValidator validator) {
        this.productRepository = springDataSourceProductRepository;
        this.productConverter = productConverter;
        this.pagingProductRepository = pagingProductRepository;
        this.validator = validator;
    }

    @Override
    public ProductDTO getProductById(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product not found: " + id));
        return productConverter.convertToProductDTO(product);
    }

    @Override
    public Collection<ProductDTO> getAllProducts() {
        return productConverter.convertToProductDTO(productRepository.findAll());
    }

    @Override
    @Transactional
    public void deleteProduct(Integer id) {
        LOGGER.debug(String.format("Request to delete product with id %s", id));
        Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product not found: " + id));
        productRepository.delete(product);
    }

    @Override
    @Transactional
    public Integer createProduct(ProductDTO productToCreate) {
        validator.validateProduct(productToCreate);
        Product product = productConverter.convertToEntity(productToCreate);
        Product savedProduct = productRepository.save(product);
        return savedProduct.getId();
    }

    @Override
    @Transactional
    public ProductDTO updateProduct(Integer id, ProductDTO productToUpdate) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product not found: " + id));
        validator.validateProduct(productToUpdate);
        Product entityToUpdate = productConverter.convertToEntity(productToUpdate);
        entityToUpdate.setId(id);
        Product updatedEntity = productRepository.save(entityToUpdate);
        return productConverter.convertToProductDTO(updatedEntity);
    }

    @Override
    public List<ProductDTO> search(ProductFilterDTO filter) {
        String nameLike = addPercentSigns(filter.getName());
        String descriptionLike = addPercentSigns(filter.getDescription());
        List<Product> allByNameOrDescription = productRepository.findAllByNameLikeOrDescriptionLike(nameLike, descriptionLike);
        return productConverter.convertToProductDTO(allByNameOrDescription);
    }

    @Override
    public Page<ProductDTO> getPage(Pageable pageable) {
        LOGGER.trace("Products by page");
        Page<Product> productPage = pagingProductRepository.findAll(pageable);
        List<ProductDTO> productDTOS = productConverter.convertToProductDTO(productPage.getContent());
        return new PageImpl<>(productDTOS, productPage.getPageable(), productPage.getTotalElements());
    }

    private String addPercentSigns(String string) {
        LOGGER.debug("Add percent signs to string for request 'LIKE'");
        string = "%" + string + "%";
        return string;
    }
}
