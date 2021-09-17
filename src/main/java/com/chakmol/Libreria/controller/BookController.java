package com.chakmol.Libreria.controller;

import com.chakmol.Libreria.entity.Book;
import com.chakmol.Libreria.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/addBook")
    public String saveBook(@RequestBody Book book){
        bookRepository.save(book);
        return "Added book with id: " + book.getId();
    }
    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable("id") long id){
        bookRepository.deleteById(id);
    }

    @GetMapping("/findAllBooks/{id}")
    public Optional<Book> getBookById(@PathVariable("id") long id){
        return bookRepository.findById(id);
    }

    @GetMapping("/findAllBooks")
    public ResponseEntity<List<Book>> GetAllBooks(){
        return new ResponseEntity<List<Book>>(bookRepository.findAll(), HttpStatus.OK);
    }
}
