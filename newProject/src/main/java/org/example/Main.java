package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages = "org.example")
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }

}

// https://asecuritysite.com/encryption/plain:- a57ccffc716b3d0c15b0d5a7edc3d3ae2d32b78d20007ff9ad33ce4878493c44
// 3273357638792F423F4528482B4D6251655368566D597133743677397A244326
// To check the key which is created by postman visit the website :- https://jwt.io//
//Youtube :- https://www.youtube.com/watch?v=ZjFpToCQCxM
