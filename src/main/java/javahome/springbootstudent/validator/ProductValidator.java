package javahome.springbootstudent.validator;


import javahome.springbootstudent.controller.dto.ProductDTO;
import javahome.springbootstudent.exception.ValidationException;
import org.springframework.stereotype.Component;


@Component
public class ProductValidator {
    public void validateProduct(ProductDTO productDTO) {
        if (productDTO.getName().contains("$")) {
            throw new ValidationException("Product name cannot contains symbol '$'");
        } else if (productDTO.getDescription().contains("$")) {
            throw new ValidationException("Product description cannot contains symbol '$'");
        }
    }
}
