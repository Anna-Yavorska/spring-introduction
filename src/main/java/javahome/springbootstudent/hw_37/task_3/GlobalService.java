package javahome.springbootstudent.hw_37.task_3;

import jakarta.annotation.PostConstruct;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GlobalService {
    private final UserService userService;
    private final ApplicationContext applicationContext;

    public GlobalService(UserService userService, ApplicationContext applicationContext) {
        this.userService = userService;
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void init() {
        UserRepository userRepository = applicationContext.getBean("userRepository", UserRepository.class);
        List<String> fullNames = userService.printAllUsers();
        fullNames.forEach(System.out::println);
    }
}
