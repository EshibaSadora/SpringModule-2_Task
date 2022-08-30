package ru.shornikov.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.shornikov.entity.Book;

public interface BookRepository extends JpaRepository<Book, UUID> {

}

