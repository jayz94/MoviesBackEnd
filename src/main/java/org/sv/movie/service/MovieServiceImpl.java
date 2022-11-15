package org.sv.movie.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.sv.movie.dao.MovieRepository;
import org.sv.movie.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{
    //inyeccion de dependencia con Autowired

    @Autowired
    private MovieRepository movieRepo;

    /*public void MovieServiceImpl(MovieRepository repo){
        movieRepo=repo;
    }*/
    @Override
    //de spring framework no el de java
    @Transactional(readOnly = true)//readOnly para que no realice cambios en la BD
    public List<Movie> findAll() {
        return (List<Movie>) movieRepo.findAll();
    }

    public Optional<Movie> findByTitle(String title){
        return movieRepo.findByTitle(title);
    }

    public List<Movie> findByFieldSort(Sort sort){ return movieRepo.findByFieldSort(sort); }
    public List<Movie> findByTitleLike(String title){
        return movieRepo.findByTitleLike(title);
    }
    public List<Movie> findByTitleOrId(String title, int id){
        return movieRepo.findByTitleOrId(title,id);
    }
}
