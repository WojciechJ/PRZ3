package Przyrost_3.services;
import Przyrost_3.entities.CrewMember;
import Przyrost_3.repositories.CrewMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CrewMemberServiceIMP implements CrewMemberService {


    @Autowired
    private CrewMemberRepository repository;

    @Override
    public Iterable<CrewMember> listAll() {
        return repository.findAll();
    }

    @Override
    public CrewMember getById(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public CrewMember save(CrewMember obj) {
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

    public Iterable<CrewMember> listAllPaging(Integer pageNr, Integer howManyOnPage) {
        return repository.findAll(new PageRequest(pageNr, howManyOnPage));
    }

    @Override
    public Iterable<CrewMember> getByName(String name) {
        return repository.findByName("%" + name + "%");
    }

    @Override
    public long howMany() {
        return repository.count();
    }

}
