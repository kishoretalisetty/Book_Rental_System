package org.example.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookNotAvailableException extends RuntimeException{
    private String message;
}
