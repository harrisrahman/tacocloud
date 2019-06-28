package org.study.pcfdevcert.repository;

import org.springframework.data.repository.CrudRepository;
import org.study.pcfdevcert.domain.Ingredient;

public interface IngredientRepository
        extends CrudRepository<Ingredient,String> {

}
