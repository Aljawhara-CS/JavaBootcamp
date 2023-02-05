package com.example.hw19.Controller;

import com.example.hw19.Model.Director;
import com.example.hw19.Model.Movie;
import com.example.hw19.Repostry.MovieRep;
import com.example.hw19.Service.DirectorService;
import com.example.hw19.Service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
@RequiredArgsConstructor
public class MovieController {



    private final MovieService movieService;

    @GetMapping("/get")
    public ResponseEntity getMovies()
    {
        List<Movie> movies= movieService.getMovies();
        return  ResponseEntity.status(200).body(movies);

    }

    @PostMapping("/add")
    public ResponseEntity addMovie(@Valid @RequestBody Movie movie)

    {

        movieService.addMovie(movie);
        return ResponseEntity.status(200).body(" Movie Added!");

    }




    @PutMapping("/update/{id}")
    public  ResponseEntity updateMovie(@PathVariable Integer id, @Valid@RequestBody  Movie movie)
    {

        movieService.UpdateMovie(movie,id);
        return ResponseEntity.status(200).body("Movie Updated");


    }



    @DeleteMapping("/delete/{id}")
    public  ResponseEntity deleteMovie(@PathVariable Integer id)
    {

        movieService.deleteMovie(id);
        return ResponseEntity.status(200).body("Movie Deleted");


    }



    @GetMapping("/title/{name}")
    public ResponseEntity getMoviesByTitle(@PathVariable String name )
    {

        Movie movie = movieService.getMovieByname(name);
        return  ResponseEntity.status(200).body(movie);

    }


    @GetMapping("/duration/{name}")
    public ResponseEntity getDurationByname(@PathVariable String name )
    {

        Movie movie =movieService.getDurationByname(name);
        return  ResponseEntity.status(200).body(movie.getDuration());

    }

    @GetMapping("/director/{name}")
    public ResponseEntity getDirectorByname(@PathVariable String name )
    {

        Director director = movieService.getDirectorByname(name);
        return  ResponseEntity.status(200).body(director.getName());

    }


    @GetMapping("/dir/{id}")
    public ResponseEntity getDurationById(@PathVariable Integer id )
    {

        List <Movie> movie =movieService.getMoviesbydirector(id);
        return  ResponseEntity.status(200).body(movie);

    }


    @GetMapping("/return/{name}")
    public ResponseEntity getRatingByName(@PathVariable String name )
    {
        Movie movie= movieService.findRatingByName(name);
        return  ResponseEntity.status(200).body(movie.getRating());

    }

    @GetMapping("/rate")
    public ResponseEntity getMoviesAboveRate()
    {
       List<Movie> movies= movieService.getMoviesAboveRate();
        return  ResponseEntity.status(200).body(movies);

    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity getMoviesByGenre(@PathVariable String genre)
    {
        List<Movie>  movies= movieService.getMoviesByGenre(genre);
        return  ResponseEntity.status(200).body(movies);

    }




}
