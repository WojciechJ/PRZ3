package Przyrost_3.repositories;

import Przyrost_3.entities.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
public interface ActorRepository extends CrudRepository<Actor, Integer>, PagingAndSortingRepository<Actor, Integer> {

    Actor findById(int id);

    @Query("select a from Actor a where a.id = ?1")
    Integer checkIfExist(Integer id);

    @Query("select a from Actor a where a.name like ?1")
    Iterable<Actor> findByName(String name);
}
