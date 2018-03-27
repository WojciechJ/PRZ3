package Przyrost_3.services;

import Przyrost_3.entities.CrewMember;

public interface CrewMemberService {

    Iterable<CrewMember> listAll();

    CrewMember getById(Integer id);

    Iterable<CrewMember> getByName(String name);

    CrewMember save(CrewMember actor);

    void delete(Integer id);

    Boolean checkIfExist(Integer id);

    Iterable<CrewMember> listAllPaging(Integer pageNr, Integer howManyOnPage);

    long howMany();
}
