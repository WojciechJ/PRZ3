package Przyrost_3.repositories;

import Przyrost_3.entities.CrewMember;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
public interface CrewMemberRepository extends CrudRepository<CrewMember, Integer>, PagingAndSortingRepository<CrewMember, Integer> {

    CrewMember findById(int id);

    @Query("select c from CrewMember c where c.id = ?1")
    Integer checkIfExist(Integer id);

    @Query("select c from CrewMember c where c.name like ?1")
    Iterable<CrewMember> findByName(String name);
}
