package org.sv.movie.dao;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.sv.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.sv.movie.entity.Response.MovieResponse;
import java.util.List;
import java.util.Optional;


//se implementan todos los metodos get y set de MOvie mediante JPA
@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    @Query("select new org.sv.movie.entity.Movie(m.id,m.name,m.user,m.adult) from Movie m ")
    List<Movie> findAll();
    @Query("select m from Movie m where m.name=?1")
    Optional<Movie> findByName(String name);
    @Query("select m from Movie m")
    List<Movie> findByFieldSort(Sort sort);
    List<Movie> findMoviesByNameLike(String name);
    @Query("select new org.sv.movie.entity.Response.MovieResponse(m.name,m.user.firstName) from Movie m where m.name like %:paramName% or m.id=:paramId")
    List<MovieResponse> findByNameOrId(@Param("paramName")  String name,@Param("paramId") long id);
}

