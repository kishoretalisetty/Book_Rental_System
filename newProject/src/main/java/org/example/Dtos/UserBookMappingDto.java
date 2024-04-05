package org.example.Dtos;

import lombok.Data;

import java.util.Date;

@Data
public class UserBookMappingDto {

    private Long userBookMappingId;

    private Long userId;

    private Long bookId;

    private Date startDate;

    private Date endDate;

    private  Date submissionDate;

    private Long fine;

    private Date createdDate;

    private Date updatedDate;
}
