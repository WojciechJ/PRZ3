package Przyrost_3.services;
import Przyrost_3.entities.Actor;
import Przyrost_3.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ActorServiceIMP implements ActorService {


    @Autowired
    private ActorRepository repository;

    @Override
    public Iterable<Actor> listAll() {
        return repository.findAll();
    }

    @Override
    public Actor getById(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public Actor save(Actor obj) {
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

    public Iterable<Actor> listAllPaging(Integer pageNr, Integer howManyOnPage) {
        return repository.findAll(new PageRequest(pageNr, howManyOnPage));
    }

    @Override
    public Iterable<Actor> getByName(String name) {
        return repository.findByName("%" + name + "%");
    }

    @Override
    public long howMany() {
        return repository.count();
    }

}
