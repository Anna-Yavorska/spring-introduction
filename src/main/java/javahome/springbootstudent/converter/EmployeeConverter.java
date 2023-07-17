package javahome.springbootstudent.converter;

import javahome.springbootstudent.controller.dto.EmployeeDTO;
import javahome.springbootstudent.repository.model.Employee;
import javahome.springbootstudent.repository.model.Shop;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeConverter {
    public Employee convertToEntity(EmployeeDTO source) {
        Shop shop = new Shop(source.getShopId());
        return new Employee(source.getId(),
                source.getName(),
                source.getSurname(),
                shop,
                source.getTitle());
    }

    public EmployeeDTO convertToEmployeeDTO(Employee source) {
        return convertEmployeeToDto(source);
    }

    public List<EmployeeDTO> convertToEmployeeDTO(Collection<Employee> source) {
        return source.stream()
                .map(this::convertEmployeeToDto)
                .collect(Collectors.toList());
    }

    private EmployeeDTO convertEmployeeToDto(Employee source) {
        EmployeeDTO result = new EmployeeDTO();
        result.setId(source.getId());
        result.setName(source.getName());
        result.setSurname(source.getSurname());
        result.setShopId(source.getShop().getId());
        result.setTitle(source.getTitle());
        return result;
    }
}
