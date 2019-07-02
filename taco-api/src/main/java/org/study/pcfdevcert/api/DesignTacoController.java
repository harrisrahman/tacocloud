package org.study.pcfdevcert.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.study.pcfdevcert.domain.Ingredient;
import org.study.pcfdevcert.domain.Taco;
import org.study.pcfdevcert.repository.IngredientRepository;
import org.study.pcfdevcert.repository.TacoRepository;

import java.util.Optional;

@RestController
@RequestMapping(path = "/design",produces = "application/json")
@CrossOrigin(origins = "*")
public class DesignTacoController {

    private TacoRepository repository;
    private IngredientRepository ingRepo;

//    @Autowired
//    EntityLinks entityLinks;

    @Autowired
    public DesignTacoController(TacoRepository repository, IngredientRepository ingRepo){
        this.repository = repository;
        this.ingRepo = ingRepo;
    }

    @GetMapping(path = "/recent")
    public Iterable<Taco> recentTacos(){
        PageRequest page = PageRequest.of(0,12, Sort.by("createdAt").descending());
        return repository.findAll(page).getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id) {
        Optional<Taco> optionalTaco = repository.findById(id);
        if (optionalTaco.isPresent()) {
            return  new ResponseEntity<>(optionalTaco.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/ingredients")
    public Iterable<Ingredient> getIngredients(){
        return ingRepo.findAll();
    }
}
