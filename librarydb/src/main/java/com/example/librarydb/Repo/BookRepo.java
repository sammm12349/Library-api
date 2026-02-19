package com.example.librarydb.Repo;

import com.example.librarydb.Domain.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface BookRepo extends JpaRepository<Books,Long> {
    Optional<Books> findByIsbn(String isbn);
    void deleteById(long id);
}
