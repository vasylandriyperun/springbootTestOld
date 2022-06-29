package org.learning.springbootTest.services;

import org.learning.springbootTest.model.Book;
import org.learning.springbootTest.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository repository;

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

}
