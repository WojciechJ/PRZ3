package Przyrost_3.repositories;

import Przyrost_3.entities.CastMember;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
public interface CastMemberRepository extends CrudRepository<CastMember, Integer>, PagingAndSortingRepository<CastMember, Integer> {

    CastMember findById(int id);

    @Query("select c from CastMember c where c.id = ?1")
    Integer checkIfExist(Integer id);

    @Query("select c from CastMember c where c.name like ?1")
    Iterable<CastMember> findByName(String name);
}
