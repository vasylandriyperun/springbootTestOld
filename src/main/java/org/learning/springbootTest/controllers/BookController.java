package org.learning.springbootTest.controllers;

import org.learning.springbootTest.model.Book;
import org.learning.springbootTest.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping(path = "/books")
    public List<Book> getStudentByName() {
        return bookService.getAllBooks();
    }


}
