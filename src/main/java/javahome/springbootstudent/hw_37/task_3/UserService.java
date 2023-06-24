package javahome.springbootstudent.hw_37.task_3;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<String> printAllUsers() {
        List<String> fullNames = new ArrayList<>();
        List<User> allUsers = userRepository.findAllUsers();
        for (User user : allUsers) {
            String fullName = user.name() + " " + user.surname();
            fullNames.add(fullName);
        }
        return fullNames;
    }
}
