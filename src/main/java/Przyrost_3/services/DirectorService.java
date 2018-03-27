package Przyrost_3.services;

import Przyrost_3.entities.Director;

public interface DirectorService {

    Iterable<Director> listAll();

    Director getById(Integer id);

    Iterable<Director> getByName(String name);

    Director save(Director actor);

    void delete(Integer id);

    Boolean checkIfExist(Integer id);

    Iterable<Director> listAllPaging(Integer pageNr, Integer howManyOnPage);

    long howMany();
}
