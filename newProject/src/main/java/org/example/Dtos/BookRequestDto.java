package org.example.Dtos;

import lombok.Data;

@Data
public class BookRequestDto {

    private String name;

    private String auothorName;

    private String genre;

    private Boolean available;

}
