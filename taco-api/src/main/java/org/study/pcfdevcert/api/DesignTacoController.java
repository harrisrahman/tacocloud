package org.study.pcfdevcert.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.study.pcfdevcert.resourceassembler.TacoResourceAsembler;
import org.study.pcfdevcert.domain.Taco;
import org.study.pcfdevcert.repository.IngredientRepository;
import org.study.pcfdevcert.repository.TacoRepository;
import org.study.pcfdevcert.resource.TacoResource;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping(path = "/design",produces = "application/json")
@CrossOrigin(origins = "*")
public class DesignTacoController {

    private TacoRepository repository;

//    @Autowired
//    EntityLinks entityLinks;

    @Autowired
    public DesignTacoController(TacoRepository repository, IngredientRepository ingRepo){
        this.repository = repository;
    }

    @GetMapping(path = "/recent")
    public Resources<TacoResource> recentTacos(){
        PageRequest page = PageRequest.of(0,12, Sort.by("createdAt").descending());
        List<Taco> recentTacos =  repository.findAll(page).getContent();
        List<TacoResource> tacoResources= new TacoResourceAsembler().toResources(recentTacos);
        Resources<TacoResource> recentResources = new Resources<>(tacoResources);
        recentResources.add(linkTo(methodOn(DesignTacoController.class).recentTacos())
                                .withRel("recents"));
        return recentResources;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id) {
        Optional<Taco> optionalTaco = repository.findById(id);
        if (optionalTaco.isPresent()) {
            return  new ResponseEntity<>(optionalTaco.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco){
        return repository.save(taco);
    }
}
