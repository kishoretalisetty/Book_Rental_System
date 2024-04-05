package org.example.Services;

import org.example.Dtos.BookRequestDto;
import org.example.Entities.Book;
import org.example.Exceptions.BookNotAvailableException;
import org.example.Exceptions.BookNotFoundException;
import org.example.Exceptions.NoBooksException;
import org.example.Repositorys.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImp implements BookService{

    //Title, Author, Genre, Availability
    @Autowired
    private BookRepository bookRepository;

    @Override
    public void addBook(BookRequestDto bookRequestDto){
        Book book=new Book();
        book.setName(bookRequestDto.getName());
        book.setAuothorName(bookRequestDto.getAuothorName());
        book.setGenre(bookRequestDto.getGenre());
        book.setAvailable(true);

        bookRepository.save(book);
    }

    @Override
    public boolean isAvailble(String bookName){
       List<Book> bookList= bookRepository.findAll();
       List<Book> booksByName=bookList.stream().
               filter(b->b.getName().equals(bookName)).
               collect(Collectors.toList());

       for(Book book:booksByName){
           if(book.isAvailable())return true;
       }

       return false;
    }

    @Override
    public void deleteBook(Book book){
        bookRepository.delete(book);
    }

    @Override
    public Book getBookById(Long bookId){
        Optional<Book> op= bookRepository.findById(bookId);
        return op.get();
    }

    @Override
   public  Book getBook(String bookName){
       List<Book> bookList= bookRepository.findAll();
//       System.out.println(bookList);
       List<Book> booksByName=bookList.stream().
               filter(b->b.getName().equals(bookName)).
               collect(Collectors.toList());
       if(booksByName.size()==0){
           throw new BookNotFoundException("Book Not Found by this Id");
       }
       for(Book book:booksByName){
           if(book.isAvailable()){
               updateBook(book,false);
              return book;
           }
       }

       throw new BookNotAvailableException("Book is Not Available");

   }

   @Override
   public  void updateBook(Book book, boolean b){
        book.setAvailable(b);
    }

    @Override
    public List<Book> getAllBooks(){
        List<Book> bookList=bookRepository.findAll();
        if(bookList.isEmpty()){
            throw new  NoBooksException( " There No More Books Left ");
        }
        return bookList;
    }
}
