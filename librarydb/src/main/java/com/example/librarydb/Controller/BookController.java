package com.example.librarydb.Controller;

import com.example.librarydb.Domain.Books;
import com.example.librarydb.LibrarydbApplication;
import com.example.librarydb.Service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Books>> findAllBooks(){
        List<Books> books = bookService.findAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Books> findBookById(@PathVariable("id") Long id){
        Books books = bookService.findBookById(id);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Books> addBook(@RequestBody Books books){
        Books newBook = bookService.addBook(books);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Books> updateBook(@RequestBody Books books){
        Books updatedBook = bookService.updateBook(books);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }
    @GetMapping("/find/isbn/{isbn}")
    public ResponseEntity<Books> findBookByIsbn(@PathVariable String isbn){
        Books books = bookService.findBookByIsbn(isbn);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long id){
        bookService.deleteBookById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
