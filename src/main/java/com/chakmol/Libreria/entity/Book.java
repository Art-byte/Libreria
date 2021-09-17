package com.chakmol.Libreria.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Book")
public class Book {

    @Id
    private long id;
    private String title;
    private String gender;
    private String isbn;
    private String author;
}
