package com.JHU.oose.mybook.service;

import com.JHU.oose.mybook.exception.UserNotFindException;
import com.JHU.oose.mybook.model.Book;
import com.JHU.oose.mybook.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BookService {
    private final BookRepo bookRepo;

    @Autowired
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public Book addBook(Book book){
        book.setBookCode(UUID.randomUUID().toString());
        return bookRepo.save(book);
    }

    public List<Book> findAllBook(){
        return bookRepo.findAll();
    }

    public void updateBook(Book book){
        bookRepo.save(book);
    }

    public Book findBookById(Long id){
        return bookRepo.findBookById(id)
                .orElseThrow(()->new UserNotFindException("User by id "+id+" was not found") );
    }

    public void deleteBook(Long id){
        bookRepo.deleteBookById(id);
    }
}
