package org.example.Services;

import org.example.Dtos.UserRequestDto;
import org.example.Entities.User;
import org.example.Exceptions.UserNotFoundException;
import org.example.Repositorys.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService {


// Email, Password, First Name, Last Name, Role

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(UserRequestDto userRequestDto){
        User user=new User();
        user.setFirstName(userRequestDto.getFirstName());
        user.setLastName(userRequestDto.getLastName());
        user.setName(userRequestDto.getEmail());
        user.setPassword(passwordEncoder.encode( userRequestDto.getPassword()));
        if(userRequestDto.getRole()!=null)
        user.setRole(userRequestDto.getRole());
        else{
            user.setRole("USER");
        }


        userRepository.save(user);

        return user;
    }

    @Override
    public User getUserById(Long id){
     Optional<User> user=  userRepository.findById(id);
     if(user.isEmpty())throw new UserNotFoundException("User Not Found");
//     UserRequestDto userRequestDto=new ModelMapper().map(user,UserRequestDto.class);
     return user.get();
    }

    @Override
    public void deleteUser(UserRequestDto userRequestDto){
        User user=new ModelMapper().map(userRequestDto, User.class);
        userRepository.delete(user);
    }

    @Override
    public void deleteUserById(Long userId){
        userRepository.deleteById(userId);
    }


}
