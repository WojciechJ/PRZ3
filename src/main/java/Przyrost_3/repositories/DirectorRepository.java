package Przyrost_3.repositories;

import Przyrost_3.entities.Director;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
public interface DirectorRepository extends CrudRepository<Director, Integer>, PagingAndSortingRepository<Director, Integer> {

    Director findById(int id);

    @Query("select a from Director a where a.id = ?1")
    Integer checkIfExist(Integer id);

    @Query("select a from Director a where a.name like ?1")
    Iterable<Director> findByName(String name);
}
