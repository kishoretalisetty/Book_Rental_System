package org.example.Exceptions;

import lombok.Data;

@Data
public class NoBooksException extends  RuntimeException{
   private String messsage;
   public NoBooksException(String st){
       this.messsage=st;
   }
}
