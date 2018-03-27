package Przyrost_3.controllers;

import Przyrost_3.entities.Director;
import Przyrost_3.services.DirectorService;
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

public class DirectorController {


    @Autowired
    private DirectorService service;

    @RequestMapping(value = "/directors", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Director> list() {
        return service.listAll();
    }

    @RequestMapping(value = "/directors/{page}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Director> list(@PathVariable("page") Integer pageNr, @RequestParam("size") Optional<Integer> howManyOnPage) {
        return service.listAllPaging(pageNr, howManyOnPage.orElse(2));
    }

    @RequestMapping(value = "/directors_by_name", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Director> getByName(@RequestParam("name") String name) {
        return service.getByName(name);
    }

    @RequestMapping(value = "/director", method = RequestMethod.POST)
    public ResponseEntity<Director> create(@RequestBody @Valid @NotNull Director obj) {
        service.save(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/director", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Director getByParamPublicId(@RequestParam("id") Integer publicId) {
        return service.getById(publicId);
    }

    @RequestMapping(value = "/director/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Director getByPublicId(@PathVariable("id") Integer publicId){ return service.getById(publicId); }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/director/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Director> delete(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/director", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Director obj) {
        Director actorFromData = service.getById(obj.getId());
        if (Objects.nonNull(actorFromData)) {
            service.save(obj);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/director_how_many", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public long howMany() {
        return service.howMany();
    }
}
