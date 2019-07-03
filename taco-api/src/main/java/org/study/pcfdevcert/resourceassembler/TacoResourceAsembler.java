package org.study.pcfdevcert.resourceassembler;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.study.pcfdevcert.api.DesignTacoController;
import org.study.pcfdevcert.domain.Taco;
import org.study.pcfdevcert.resource.TacoResource;

public class TacoResourceAsembler extends ResourceAssemblerSupport<Taco,TacoResource> {

    public TacoResourceAsembler() {
        super(DesignTacoController.class, TacoResource.class);
    }

    @Override
    public TacoResource toResource(Taco taco) {
        return createResourceWithId(taco.getId(),taco);
    }

    @Override
    protected TacoResource instantiateResource(Taco entity) {
        return new TacoResource(entity);
    }
}
