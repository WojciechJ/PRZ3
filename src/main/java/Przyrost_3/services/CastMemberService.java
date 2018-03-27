package Przyrost_3.services;

import Przyrost_3.entities.CastMember;

public interface CastMemberService {

    Iterable<CastMember> listAll();

    CastMember getById(Integer id);

    Iterable<CastMember> getByName(String name);

    CastMember save(CastMember actor);

    void delete(Integer id);

    Boolean checkIfExist(Integer id);

    Iterable<CastMember> listAllPaging(Integer pageNr, Integer howManyOnPage);

    long howMany();
}
