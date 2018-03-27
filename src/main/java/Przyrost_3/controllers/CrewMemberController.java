package Przyrost_3.controllers;

import Przyrost_3.entities.CrewMember;
import Przyrost_3.services.CrewMemberService;
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


public class CrewMemberController {


    @Autowired
    private CrewMemberService service;

    @RequestMapping(value = "/crew_members", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<CrewMember> list() {
        return service.listAll();
    }

    @RequestMapping(value = "/crew_members/{page}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<CrewMember> list(@PathVariable("page") Integer pageNr, @RequestParam("size") Optional<Integer> howManyOnPage) {
        return service.listAllPaging(pageNr, howManyOnPage.orElse(2));
    }

    @RequestMapping(value = "/crew_members_by_name", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<CrewMember> getByName(@RequestParam("name") String name) {
        return service.getByName(name);
    }

    @RequestMapping(value = "/crew_member", method = RequestMethod.POST)
    public ResponseEntity<CrewMember> create(@RequestBody @Valid @NotNull CrewMember obj) {
        service.save(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/crew_member", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CrewMember getByParamPublicId(@RequestParam("id") Integer publicId) {
        return service.getById(publicId);
    }

    @RequestMapping(value = "/crew_member/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CrewMember getByPublicId(@PathVariable("id") Integer publicId){ return service.getById(publicId); }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/crew_member/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CrewMember> delete(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/crew_member", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull CrewMember obj) {
        CrewMember actorFromData = service.getById(obj.getId());
        if (Objects.nonNull(actorFromData)) {
            service.save(obj);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/crew_member_how_many", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public long howMany() {
        return service.howMany();
    }
}
