package org.example.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmailAlreadyExistsException extends  RuntimeException{
    private String message;
}
