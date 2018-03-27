package Przyrost_3.services;

import Przyrost_3.entities.Actor;

public interface ActorService {

    Iterable<Actor> listAll();

    Actor getById(Integer id);

    Iterable<Actor> getByName(String name);

    Actor save(Actor actor);

    void delete(Integer id);

    Boolean checkIfExist(Integer id);

    Iterable<Actor> listAllPaging(Integer pageNr, Integer howManyOnPage);

    long howMany();
}
