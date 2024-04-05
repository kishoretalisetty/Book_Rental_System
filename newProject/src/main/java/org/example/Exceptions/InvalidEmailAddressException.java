package org.example.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InvalidEmailAddressException extends  RuntimeException {
    private String message;
}
