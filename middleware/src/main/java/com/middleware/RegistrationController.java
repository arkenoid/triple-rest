package com.middleware;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method=RequestMethod.POST)
    @ResponseStatus( HttpStatus.CREATED )
    public void register(
            @RequestParam(value = "name", required = true) String name) {
    	
    	Registration registration = new Registration(counter.incrementAndGet(),
                String.format(template, name));
    	
    	System.out.println(registration);
    }
}
