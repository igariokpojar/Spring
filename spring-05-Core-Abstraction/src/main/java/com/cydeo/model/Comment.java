package com.cydeo.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class Comment { // no @Component to any model classes

    private String author;
    private String text;
}
