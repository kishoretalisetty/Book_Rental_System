package org.example.Repositorys;

import org.example.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByName(String bookName);


//    @Query(nativeQuery = true, value = "select * from Book where id = :id")
//    public String getBookById(long id);
}
