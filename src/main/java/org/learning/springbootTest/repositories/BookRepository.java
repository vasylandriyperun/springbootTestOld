package org.learning.springbootTest.repositories;

import org.learning.springbootTest.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
