package javahome.springbootstudent.hw_40.validator;

import javahome.springbootstudent.hw_40.controller.dto.ProductDTO;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class ProductValidator {
    private static final Pattern NUMBERS = Pattern.compile("\\d+");

    public void validateProduct(ProductDTO productDTO) {
        String name = productDTO.getName();
        if (name.length() == 0 || NUMBERS.matcher(name).matches()) {
            throw new ValidationException("Name is invalid!");
        }
    }
}
