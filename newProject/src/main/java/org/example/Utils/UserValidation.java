package org.example.Utils;

import org.example.Entities.User;
import org.example.Repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserValidation {

    @Autowired
    private UserRepository userRepository;

    public boolean registerUserValidation(String userName){
        Optional<User> optionalUser=userRepository.findByName(userName);

        return optionalUser.isEmpty();
    }

    public boolean emailValidation(String email){
        //usergmail.com = 9 length

        int length=email.length();
        String st=email.substring(length-9);
        return st.equals("gmail.com");
    }
}
