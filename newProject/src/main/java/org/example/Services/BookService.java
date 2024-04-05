package org.example.Services;

import org.example.Dtos.BookRequestDto;
import org.example.Entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    void addBook(BookRequestDto book);

    boolean isAvailble(String bookName);

    void deleteBook(Book book);

    Book getBook(String bookName);

    void updateBook(Book book, boolean b);
    Book getBookById(Long bookId);
     List<Book> getAllBooks();
}
