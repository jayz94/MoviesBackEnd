package org.sv.movie.controllers;
import org.springframework.data.domain.Sort;
import org.sv.movie.entity.Movie;
import org.sv.movie.entity.Response.MovieResponse;
import org.sv.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/movies")

public class MovieController {
    @Autowired//inyeccion de dependencias
    private  MovieService serviceMovie;
/*
    //create  @RequestBody para decirle que recibiremos en el cuerpo un usuario
    @PostMapping
    public ResponseEntity<?> create (@RequestBody Movie movie){
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceMovie.save(movie));
        //devuelve el estado creado y en el body
    }

    @GetMapping("/{id}") //se usa pathVariable para hacer match con el parametro
    public ResponseEntity<?> get(@PathVariable(value ="id") Long idMovie){
        Optional<Movie> oMovie = serviceMovie.findById(idMovie);
        if(!oMovie.isPresent())
            return  ResponseEntity.notFound().build();
        return ResponseEntity.ok(oMovie);
    }
    //update
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Movie movieDetails,@PathVariable(value="id") Long idMovie){
        Optional<Movie> oMovie = serviceMovie.findById(idMovie);
        if(!oMovie.isPresent())
            return ResponseEntity.notFound().build();
        //BeanUtils.copyProperties(movieDetails,oMovie.get(),"id");copia el objeto movieDetails a oMovie ignorando el id
        oMovie.get().setName(movieDetails.getName());
        //hacemos oMovie.get() por que es un objeto optional que contiene una oMovie
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceMovie.save(oMovie.get()));
    }
    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable(value = "id") Long movieId){
        if(!serviceMovie.findById(movieId).isPresent())
            return ResponseEntity.notFound().build();
        serviceMovie.delete(movieId);
        return ResponseEntity.ok().build();
    }
*/

    @GetMapping
    public List<Movie> getAll(){
        //se utiliza el StreamSuport de java 8 para convertir el Iterable<Movie> a List<Movie>
        //splitIterator es para iterar cada elemento
        List<Movie> movies = serviceMovie.findAll();
        return movies;
    }
    @GetMapping("/GetByTitle")
    public Optional<Movie> getByTile(String title){
        Optional<Movie> movies = serviceMovie.findByTitle(title);
        return movies;
    }

    @GetMapping("/GetOrderXField")
    public List<Movie> getOrderXField(String field){
        return serviceMovie.findByFieldSort(Sort.by(field).ascending());
    }
    @GetMapping("/titleLike")
    public List<Movie> getMoviesTitleLike(String name){return serviceMovie.findByTitleLike("%"+name+"%"); }

    @GetMapping("/GetByTitleOrId")
    public List<MovieResponse> getByTitleOrId(String title, long id){
        return serviceMovie.findByTitleOrId(title,id);
    }
    @PostMapping("/Save")
    public Movie saveMovie(Movie movie){return serviceMovie.saveMovie(movie);}
}
