package pl.coderslab.controller;

import pl.coderslab.model.Book;
import pl.coderslab.model.MockBookService;

public class Test {
    public static void main(String[] args) {
        System.out.println(new MockBookService().getAllBooks());
    }
}
