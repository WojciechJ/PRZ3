package Przyrost_3.services;
import Przyrost_3.entities.CastMember;
import Przyrost_3.repositories.CastMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CastMemberServiceIMP implements CastMemberService {


    @Autowired
    private CastMemberRepository repository;

    @Override
    public Iterable<CastMember> listAll() {
        return repository.findAll();
    }

    @Override
    public CastMember getById(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public CastMember save(CastMember obj) {
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

    public Iterable<CastMember> listAllPaging(Integer pageNr, Integer howManyOnPage) {
        return repository.findAll(new PageRequest(pageNr, howManyOnPage));
    }

    @Override
    public Iterable<CastMember> getByName(String name) {
        return repository.findByName("%" + name + "%");
    }

    @Override
    public long howMany() {
        return repository.count();
    }

}
