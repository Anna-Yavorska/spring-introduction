package javahome.springbootstudent.converter;

import javahome.springbootstudent.controller.dto.UserDTO;
import javahome.springbootstudent.repository.model.User;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {
    public User convertToEntity(UserDTO source) {
        return new User(source.getId(),
                source.getName(),
                source.getSurname(),
                source.getEmail(),
                source.getPhone());
    }

    public UserDTO convertToDTO(User source) {
        return convertUserToDto(source);
    }

    public List<UserDTO> convertToDTO(Collection<User> source) {
        return source.stream()
                .map(this::convertUserToDto)
                .collect(Collectors.toList());
    }

    private UserDTO convertUserToDto(User source) {
        UserDTO result = new UserDTO();
        result.setId(source.getId());
        result.setName(source.getName());
        result.setSurname(source.getSurname());
        result.setEmail(source.getEmail());
        result.setPhone(source.getPhone());
        return result;
    }
}
