package org.example.Controller;

import lombok.extern.slf4j.Slf4j;
import org.example.Dtos.UserRequestDto;
import org.example.Exceptions.EmailAlreadyExistsException;
import org.example.Exceptions.InvalidEmailAddressException;
import org.example.Filter.JwtServiceImp.JwtService;
import org.example.Pojos.AuthRequest;
import org.example.Services.UserService;
import org.example.Utils.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/bookrent")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserValidation userValidation;


    @PostMapping(path="/registerUser") // Map ONLY POST Requests
    public @ResponseBody String registerNewUser (@RequestBody UserRequestDto req) {

        if( req.getEmail()==null ||req.getEmail().length()==0
                || !userValidation.emailValidation(req.getEmail())){
            throw new InvalidEmailAddressException("Email Address Format is Wrong");
        }

        if(!userValidation.registerUserValidation(req.getEmail())){
            throw new EmailAlreadyExistsException(" Email is Already Exists");
        }

        userService.addUser(req);

        return "User Saved";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) {
        log.info("userName = {} , password = {}",authRequest.getUsername(),authRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
                        authRequest.getPassword())
                );
        if(authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        }else {
            throw new UsernameNotFoundException("Invalid User");
        }
    }
}
