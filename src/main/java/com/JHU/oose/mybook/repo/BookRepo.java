package com.JHU.oose.mybook.repo;

import com.JHU.oose.mybook.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface BookRepo extends JpaRepository<Book,Long> {
    void deleteBookById(Long id);

    Optional<Book> findBookById(Long id);
}
