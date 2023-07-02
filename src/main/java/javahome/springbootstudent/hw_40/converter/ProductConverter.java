package javahome.springbootstudent.hw_40.converter;

import javahome.springbootstudent.hw_40.controller.dto.ProductDTO;
import javahome.springbootstudent.hw_40.repository.model.Product;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductConverter {
    public Product convertToEntity(ProductDTO source) {
        return new Product(source.getId(),
                source.getName(),
                source.getDescription(),
                source.getPrice());
    }

    public ProductDTO convertToProductDto(Product source) {
        return convertProductToDto(source);
    }

    public List<ProductDTO> convertToProductDTO(Collection<Product> source) {
        return source.stream()
                .map(this::convertProductToDto)
                .collect(Collectors.toList());
    }

    private ProductDTO convertProductToDto(Product source) {
        ProductDTO result = new ProductDTO();
        result.setId(source.id());
        result.setName(source.name());
        result.setDescription(source.description());
        result.setPrice(source.price());
        return result;
    }
}
