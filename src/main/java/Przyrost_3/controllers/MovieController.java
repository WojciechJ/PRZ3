package Przyrost_3.controllers;

import Przyrost_3.entities.Movie;
import Przyrost_3.services.MovieService;
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



public class MovieController {


    @Autowired
    private MovieService service;

    @RequestMapping(value = "/movies", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Movie> list() {
        return service.listAll();
    }

    @RequestMapping(value = "/movies/{page}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Movie> list(@PathVariable("page") Integer pageNr, @RequestParam("size") Optional<Integer> howManyOnPage) {
        return service.listAllPaging(pageNr, howManyOnPage.orElse(2));
    }

    @RequestMapping(value = "/movies_by_title", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Movie> getByTitle(@RequestParam("title") String name) {
        return service.getByTitle(name);
    }

    @RequestMapping(value = "/movie", method = RequestMethod.POST)
    public ResponseEntity<Movie> create(@RequestBody @Valid @NotNull Movie obj) {
        service.save(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/movie", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Movie getByParamPublicId(@RequestParam("id") Integer publicId) {
        return service.getById(publicId);
    }

    @RequestMapping(value = "/movie/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Movie getByPublicId(@PathVariable("id") Integer publicId){ return service.getById(publicId); }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/movie/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Movie> delete(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/movie", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Movie obj) {
        Movie actorFromData = service.getById(obj.getId());
        if (Objects.nonNull(actorFromData)) {
            service.save(obj);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/movie_how_many", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public long howMany() {
        return service.howMany();
    }
}
