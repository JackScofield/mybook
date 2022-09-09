package com.JHU.oose.mybook.controller;

import com.JHU.oose.mybook.model.Book;
import com.JHU.oose.mybook.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBook(){
        List<Book> books = bookService.findAllBook();

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id){
        Book book = bookService.findBookById(id);

        return new ResponseEntity<>(book, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book book1 = bookService.addBook(book);
        return new ResponseEntity<>(book1, HttpStatus.OK);
    }

    @PutMapping ("/update")
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        Book book1 = bookService.upDateBook(book);
        return new ResponseEntity<>(book1, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> updateBook(@PathVariable("id") Long id){
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
