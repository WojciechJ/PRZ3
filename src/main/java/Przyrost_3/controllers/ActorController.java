package Przyrost_3.controllers;

import Przyrost_3.entities.Actor;
import Przyrost_3.services.ActorService;
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


public class ActorController {


    @Autowired
    private ActorService service;

    @RequestMapping(value = "/actors", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Actor> list() {
        return service.listAll();
    }

    @RequestMapping(value = "/actors/{page}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Actor> list(@PathVariable("page") Integer pageNr, @RequestParam("size") Optional<Integer> howManyOnPage) {
        return service.listAllPaging(pageNr, howManyOnPage.orElse(2));
    }

    @RequestMapping(value = "/actors_by_name", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Actor> getByName(@RequestParam("name") String name) {
        return service.getByName(name);
    }

    @RequestMapping(value = "/actor", method = RequestMethod.POST)
    public ResponseEntity<Actor> create(@RequestBody @Valid @NotNull Actor obj) {
        service.save(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/actor", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Actor getByParamPublicId(@RequestParam("id") Integer publicId) {
        return service.getById(publicId);
    }

    @RequestMapping(value = "/actor/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Actor getByPublicId(@PathVariable("id") Integer publicId){ return service.getById(publicId); }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/actor/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Actor> delete(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/actor", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Actor obj) {
        Actor actorFromData = service.getById(obj.getId());
        if (Objects.nonNull(actorFromData)) {
            service.save(obj);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/actor_how_many", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public long howMany() {
        return service.howMany();
    }
}
