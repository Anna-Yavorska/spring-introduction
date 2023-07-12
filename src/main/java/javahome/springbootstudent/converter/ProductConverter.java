package javahome.springbootstudent.converter;

import javahome.springbootstudent.controller.dto.ProductDTO;
import javahome.springbootstudent.repository.model.Product;
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

    public ProductDTO convertToProductDTO(Product source) {
        return convertProductToDto(source);
    }

    public List<ProductDTO> convertToProductDTO(Collection<Product> source) {
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
