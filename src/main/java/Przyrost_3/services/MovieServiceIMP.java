package Przyrost_3.services;
import Przyrost_3.entities.Movie;
import Przyrost_3.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceIMP implements MovieService {


    @Autowired
    private MovieRepository repository;

    @Override
    public Iterable<Movie> listAll() {
        return repository.findAll();
    }

    @Override
    public Movie getById(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public Movie save(Movie obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        return repository.checkIfExist(id) > 0;
    }

    public Iterable<Movie> listAllPaging(Integer pageNr, Integer howManyOnPage) {
        return repository.findAll(new PageRequest(pageNr, howManyOnPage));
    }

    @Override
    public Iterable<Movie> getByTitle(String title) {
        return repository.findByTitle("%" + title + "%");
    }

    @Override
    public long howMany() {
        return repository.count();
    }

}
