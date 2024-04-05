package org.example.Services;


public interface UserBookMappingService {

    void addUserBookMappingReq(Long userId, String bookName);
   // String UserBookSubmissionByBookId(Long userId, Long bookId);
    String UserBookSubmissionByName(Long userId, String bookName);
}
