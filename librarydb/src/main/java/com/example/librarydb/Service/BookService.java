package com.example.librarydb.Service;

import com.example.librarydb.Domain.Books;
import com.example.librarydb.Repo.BookRepo;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@Slf4j
public class BookService {
    private final BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }


    public List<Books>findAllBooks(){
        return bookRepo.findAll();
   }
   public Books findBookById(Long id){
        return bookRepo.findById(id).orElseThrow(()->new RuntimeException("Book not found"));
   }
   public Books addBook(Books book){
        return bookRepo.save(book);
   }
   public Books updateBook(Books book){
        return bookRepo.save(book);
   }
   public void deleteBookById(Long id){
        bookRepo.deleteById(id);
   }
   public Books findBookByIsbn(String isbn){
        return bookRepo.findByIsbn(isbn).orElseThrow(() -> new RuntimeException("Book by Isbn not found"));
   }
}
