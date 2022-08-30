package ru.shornikov.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import ru.shornikov.entity.Book;
import ru.shornikov.entity.BookViev;


public interface BookController {

    List<Book> getAllPeople();


    String createwindow();

    String createbook(Book book);

    String getAllPeopleMirror();
}
