package Przyrost_3.services;

import Przyrost_3.entities.Movie;

public interface MovieService {

    Iterable<Movie> listAll();

    Movie getById(Integer id);

    Iterable<Movie> getByTitle(String name);

    Movie save(Movie actor);

    void delete(Integer id);

    Boolean checkIfExist(Integer id);

    Iterable<Movie> listAllPaging(Integer pageNr, Integer howManyOnPage);

    long howMany();
}
