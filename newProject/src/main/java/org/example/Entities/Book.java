package org.example.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Book")
public class Book {
   //Title, Author, Genre, Availability Status

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   @NonNull
   @Column(name = "book_title")
   private String name;

   @Column(name = "auother_name")
   private String auothorName;

   @Column(name = "genre")
   private String genre;

   @Column(name = "available")
   private boolean available;

}
