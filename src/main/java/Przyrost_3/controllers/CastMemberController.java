package Przyrost_3.controllers;

import Przyrost_3.entities.CastMember;
import Przyrost_3.services.CastMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api")


public class CastMemberController {


    @Autowired
    private CastMemberService service;

    @RequestMapping(value = "/cast_members", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<CastMember> list() {
        return service.listAll();
    }

    @RequestMapping(value = "/cast_members/{page}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<CastMember> list(@PathVariable("page") Integer pageNr, @RequestParam("size") Optional<Integer> howManyOnPage) {
        return service.listAllPaging(pageNr, howManyOnPage.orElse(2));
    }

    @RequestMapping(value = "/cast_members_by_name", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<CastMember> getByName(@RequestParam("name") String name) {
        return service.getByName(name);
    }

    @RequestMapping(value = "/cast_member", method = RequestMethod.POST)
    public ResponseEntity<CastMember> create(@RequestBody @Valid @NotNull CastMember obj) {
        service.save(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/cast_member", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CastMember getByParamPublicId(@RequestParam("id") Integer publicId) {
        return service.getById(publicId);
    }

    @RequestMapping(value = "/cast_member/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CastMember getByPublicId(@PathVariable("id") Integer publicId){ return service.getById(publicId); }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/cast_member/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CastMember> delete(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/cast_member", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull CastMember obj) {
        CastMember actorFromData = service.getById(obj.getId());
        if (Objects.nonNull(actorFromData)) {
            service.save(obj);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/cast_member_how_many", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public long howMany() {
        return service.howMany();
    }
}
