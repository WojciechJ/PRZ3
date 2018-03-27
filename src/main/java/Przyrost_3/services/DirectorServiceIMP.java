package Przyrost_3.services;
import Przyrost_3.entities.Director;
import Przyrost_3.repositories.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class DirectorServiceIMP implements DirectorService {


    @Autowired
    private DirectorRepository repository;

    @Override
    public Iterable<Director> listAll() {
        return repository.findAll();
    }

    @Override
    public Director getById(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public Director save(Director obj) {
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

    public Iterable<Director> listAllPaging(Integer pageNr, Integer howManyOnPage) {
        return repository.findAll(new PageRequest(pageNr, howManyOnPage));
    }

    @Override
    public Iterable<Director> getByName(String name) {
        return repository.findByName("%" + name + "%");
    }

    @Override
    public long howMany() {
        return repository.count();
    }

}
