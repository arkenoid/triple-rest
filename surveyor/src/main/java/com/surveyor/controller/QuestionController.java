package com.surveyor.controller;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surveyor.Question;

@RestController
public class QuestionController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/getQuestion")
    public Question getQuestion() {
        return new Question(counter.incrementAndGet(),
                            String.format(template, "poll"+new Date()));
    }
}
