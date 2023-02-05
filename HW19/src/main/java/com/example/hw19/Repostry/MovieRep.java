package com.example.hw19.Repostry;

import com.example.hw19.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface MovieRep extends JpaRepository<Movie,Integer> {

    Movie findMovieById(Integer id);


    //Create endpoint that search for a specific movie by title
    Movie findMovieByName(String name);
    //Create endpoint that takes movie name and return the duration of the movie

    @Query("select u from Movie u where u.name=?1")
    Movie findDurationByName (String name);

    //Create endpoint that takes movie name and return the director name

  ///  Movie findMovieBy (Integer id);

    //Create endpoint to list movies to a specific director
    List<Movie> findMoviesByDirectorID(Integer id);

    //Create endpoint that takes movie name and return the rate of the movie

    @Query("select u from Movie u where u.name=?1")
    Movie findRatingByName(String name);

    //Create endpoint that returns all movies above that rate
    @Query("select u from Movie u where u.rating>=3")
    List<Movie> findMoviesAboveRate();



    //Create endpoint that returns all movies by a specific genre
    List<Movie> findMoviesByGenre(String genre);



}
