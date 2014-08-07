package com.middleware;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/register.jsp")
    public Registration register(
            @RequestParam(value = "name", required = true) String name) {
        return new Registration(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
