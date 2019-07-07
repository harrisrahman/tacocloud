package org.study.pcfdevcert.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.study.pcfdevcert.domain.Ingredient;
import org.study.pcfdevcert.repository.IngredientRepository;

import java.util.Optional;

@RestController
@RequestMapping(path = "/ingredients")
@CrossOrigin(origins = "*")
public class IngredientController {

    private IngredientRepository ingRepo;

    @Autowired
    public IngredientController(IngredientRepository ingRepo) {
        this.ingRepo = ingRepo;
    }

    @GetMapping()
    public Iterable<Ingredient> getIngredients(){
        return ingRepo.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Ingredient> ingredientsById(@PathVariable("id") String id){
        Optional<Ingredient> optionalIngredient =  ingRepo.findById(id);

        if (optionalIngredient.isPresent())
            return new ResponseEntity<>(optionalIngredient.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
}
