package Przyrost_3.repositories;

import Przyrost_3.entities.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
public interface MovieRepository extends CrudRepository<Movie, Integer>, PagingAndSortingRepository<Movie, Integer> {

    Movie findById(int id);

    @Query("select m from Movie m where m.id = ?1")
    Integer checkIfExist(Integer id);

    @Query("select m from Movie m where m.title like ?1")
    Iterable<Movie> findByTitle(String title);
}
