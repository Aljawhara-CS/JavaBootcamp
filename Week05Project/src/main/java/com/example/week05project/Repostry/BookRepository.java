package com.example.week05project.Repostry;

import com.example.week05project.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository  extends JpaRepository<Book,Integer>{


//    Book findBookById(Integer id);

    Book findBookByName(String name);

    Book findBookByGenre( String genre);
}
