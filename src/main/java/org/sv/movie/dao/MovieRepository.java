package org.sv.movie.dao;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.sv.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;


//se implementan todos los metodos get y set de MOvie mediante JPA
@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    @Query("select m from Movie m where m.name=?1")
    Optional<Movie> findByTitle(String title);
    @Query("select m from Movie m")
    List<Movie> findByFieldSort(Sort sort);
    List<Movie> findByTitleLike(String title);

    List<Movie> findByTitleOrId(String title,int id);
}
