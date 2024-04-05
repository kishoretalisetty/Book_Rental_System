package org.example.Services;

import org.example.Dtos.UserRequestDto;
import org.example.Entities.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User addUser(UserRequestDto user);

     User getUserById(Long id);

    void deleteUser(UserRequestDto userRequestDto);

    void deleteUserById(Long userId);
}
