package org.study.pcfdevcert.resource;

import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;
import org.study.pcfdevcert.domain.Taco;
import org.study.pcfdevcert.resourceassembler.IngredientResourceAssembler;

import java.util.Date;
import java.util.List;

public class TacoResource extends ResourceSupport {

    @Getter
    private final String name;

    @Getter
    private final Date createdAt;

    @Getter
    private final List<IngredientResource> ingredients;

    private static final IngredientResourceAssembler assembler = new IngredientResourceAssembler();

    public TacoResource(Taco taco) {
        this.name = taco.getName();
        this.createdAt = taco.getCreatedAt();
        this.ingredients = assembler.toResources(taco.getIngredients());
    }
}
