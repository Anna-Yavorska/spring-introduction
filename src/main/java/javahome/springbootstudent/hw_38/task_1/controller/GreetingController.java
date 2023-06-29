package javahome.springbootstudent.hw_38.task_1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    @Value("${application.greeting}")
    private String greeting;

    @GetMapping("/greet")
    public String greet() {
        return greeting;
    }
}
