package com.yi.hellotest;

import org.springframework.stereotype.Component;

@Component("stringPrinter")
public class StringPrinter implements Printer {
    public void print(String message) {
        System.out.println(message);
    }
}