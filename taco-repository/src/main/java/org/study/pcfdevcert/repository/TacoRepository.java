package org.study.pcfdevcert.repository;

import org.springframework.data.repository.CrudRepository;
import org.study.pcfdevcert.domain.Taco;

public interface TacoRepository
        extends CrudRepository<Taco, Long> {

}
