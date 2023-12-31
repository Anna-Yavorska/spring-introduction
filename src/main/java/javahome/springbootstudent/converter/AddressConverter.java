package javahome.springbootstudent.converter;

import javahome.springbootstudent.controller.dto.AddressDTO;
import javahome.springbootstudent.repository.model.Address;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddressConverter {
    public Address convertToEntity(AddressDTO source) {
        return new Address(
                source.getId(),
                source.getCity(),
                source.getStreet(),
                source.getHouse()
        );
    }

    public AddressDTO convertToAddressDTO(Address source) {
        return convertAddressToDto(source);
    }

    public List<AddressDTO> convertToAddressDTO(Collection<Address> source) {
        return source.stream()
                .map(this::convertAddressToDto)
                .collect(Collectors.toList());
    }

    private AddressDTO convertAddressToDto(Address source) {
        AddressDTO result = new AddressDTO();
        result.setId(source.getId());
        result.setCity(source.getCity());
        result.setStreet(source.getStreet());
        result.setHouse(source.getHouse());
        return result;
    }

}
