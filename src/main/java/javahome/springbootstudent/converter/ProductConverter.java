package javahome.springbootstudent.converter;

import javahome.springbootstudent.controller.dto.ProductDTO;
import javahome.springbootstudent.repository.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductConverter {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductConverter.class);
    public Product convertToEntity(ProductDTO source) {
        LOGGER.warn("converting ProductDTO to entity");
        return new Product(source.getId(),
                source.getName(),
                source.getDescription(),
                source.getPrice());
    }

    public ProductDTO convertToProductDTO(Product source) {
        LOGGER.trace("converting one entity to ProductDTO");
        return convertProductToDto(source);
    }

    public List<ProductDTO> convertToProductDTO(Collection<Product> source) {
        LOGGER.debug("converting List entity to ProductDTO");
        return source.stream()
                .map(this::convertProductToDto)
                .collect(Collectors.toList());
    }

    private ProductDTO convertProductToDto(Product source) {
        ProductDTO result = new ProductDTO();
        result.setId(source.getId());
        result.setName(source.getName());
        result.setDescription(source.getDescription());
        result.setPrice(source.getPrice());
        return result;
    }
}
