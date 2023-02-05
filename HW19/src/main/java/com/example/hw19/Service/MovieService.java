package com.example.hw19.Service;


import com.example.hw19.Exception.ApiException;
import com.example.hw19.Model.Director;
import com.example.hw19.Model.Movie;
import com.example.hw19.Repostry.DirectorRepostry;
import com.example.hw19.Repostry.MovieRep;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {
    

    public final MovieRep movieRep;
    public final DirectorRepostry directorRepostry;

    public List<Movie> getMovies()
    {
        return movieRep.findAll();
    }

    public void addMovie(Movie movie)
    {
        movieRep.save(movie);
    }
    public void UpdateMovie( Movie movie,Integer id)
    {
        Movie old = movieRep.findMovieById(id);
        if (old==null)
        {         throw new ApiException(" Movie not found");
        }

        old.setDuration(movie.getDuration());
        old.setGenre(movie.getGenre());
        old.setName(movie.getName());
        old.setRating(movie.getRating());
        old.setDirectorID(movie.getDirectorID());

        movieRep.save(old);
    }

    public  void deleteMovie(Integer id)
    {

        Movie old = movieRep.findMovieById(id);

        if (old!=null)
        {
            movieRep.deleteById(id);

        }

       else throw new ApiException(" Movie not found");

    }



    public Movie getMovieByname(String name)

    {
        return movieRep.findMovieByName(name);

    }

    public Movie getDurationByname(String name)

    {
        return movieRep.findDurationByName(name);

    }


    public Director getDirectorByname(String name)

    {
        Movie movie= movieRep.findMovieByName(name);
        return  directorRepostry.findDirectorById(movie.getDirectorID());



    }




  /*  public  Movie findDurationByName(String name)
    {
       return movieRep.findDurationByName(name);
    }*/

    //Create endpoint to list movies to a specific director

    public List<Movie>  getMoviesbydirector(Integer id)

    {

     List <Movie> movie= movieRep.findMoviesByDirectorID(id);
             return movie;
    //    directorRepostry.findDirectorById(movie.getDirectorID());

    }

    //Create endpoint that takes movie name and return the rate of the movie
    public  Movie findRatingByName( String name)
    {

        Movie movies= movieRep.findRatingByName(name);
        return  movies;

        //return movies;

    }

    // Create endpoint that returns all movies above that rate

    public  List<Movie> getMoviesAboveRate()
    {

        List<Movie>  movies= movieRep.findMoviesAboveRate();
        return movies;

    }

    //Create endpoint that returns all movies by a specific genre

    public  List<Movie> getMoviesByGenre( String genre)
    {

        List<Movie>  movies= movieRep.findMoviesByGenre(genre);
        return movies;

    }







}
