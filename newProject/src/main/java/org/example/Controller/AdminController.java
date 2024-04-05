package org.example.Controller;

import org.example.Dtos.BookRequestDto;
import org.example.Dtos.UserRequestDto;
import org.example.Entities.User;
import org.example.Services.BookService;
import org.example.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookrent")
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;


    @GetMapping(path = "/getUserById")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<User> getUserById(@RequestBody Long userId){
        return  ResponseEntity.ok(userService.getUserById(userId));
    }

    @DeleteMapping(path = "/deleteUser")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteUser(@RequestBody UserRequestDto req){
        userService.deleteUser(req);
    }

    @DeleteMapping(path = "/deleteUserById")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteUserById(Long userId){
        userService.deleteUserById(userId);
    }

    @PostMapping(path = "/addBook")
    @PreAuthorize("hasAuthority('ADMIN')")
    public @ResponseBody String addNewBook(@RequestBody BookRequestDto bookRequestDto){
        bookService.addBook(bookRequestDto);
        return "Book Saved";
    }
}

