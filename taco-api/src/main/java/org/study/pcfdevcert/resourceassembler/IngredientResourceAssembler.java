package org.study.pcfdevcert.resourceassembler;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.study.pcfdevcert.api.IngredientController;
import org.study.pcfdevcert.domain.Ingredient;
import org.study.pcfdevcert.resource.IngredientResource;

public class IngredientResourceAssembler extends ResourceAssemblerSupport<Ingredient, IngredientResource> {
    public IngredientResourceAssembler() {
        super(IngredientController.class, IngredientResource.class);
    }

    @Override
    public IngredientResource toResource(Ingredient ingredient) {
        return createResourceWithId(ingredient.getId(),ingredient);
    }

    @Override
    protected IngredientResource instantiateResource(Ingredient entity) {
        return new IngredientResource(entity);
    }
}
