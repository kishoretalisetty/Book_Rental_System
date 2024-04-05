package org.example.Controller;

import org.example.Dtos.AddUserBookMappingDto;
import org.example.Entities.Book;
import org.example.Services.BookService;
import org.example.Services.UserBookMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookrent")
public class UserAccessController {
    @Autowired
    private BookService bookService;

    @Autowired
    private UserBookMappingService userBookMappingService;


    @GetMapping(path = "/isBookAvailable")
    @PreAuthorize("hasAuthority('USER')")
    public @ResponseBody boolean isAvailable(@RequestBody String bookName){
        return bookService.isAvailble(bookName);
    }

    @PostMapping(path = "/takeBook")
    @PreAuthorize("hasAuthority('USER')")
    public @ResponseBody String addUserBookMapping(@RequestBody AddUserBookMappingDto addUserBookMappingDto){
        userBookMappingService.addUserBookMappingReq(addUserBookMappingDto.getUserId(), addUserBookMappingDto.getBookName());
        return "UserBookMapping Saved";
    }

    @PutMapping(path = "/bookSubmission")
    @PreAuthorize("hasAuthority('USER')")
    public @ResponseBody String bookSubmission(@RequestBody AddUserBookMappingDto addUserBookMappingDto){
        return  userBookMappingService.UserBookSubmissionByName(addUserBookMappingDto.getUserId(),
                addUserBookMappingDto.getBookName());
    }


    @GetMapping(path = "/getAllBooks")
//    @PreAuthorize("hasAuthority('USER')")
//    @PreAuthorize("hasAuthority('ADMIN')")
    public @ResponseBody List<Book> getAllBooks() {
        return bookService.getAllBooks() ;
    }
}
