package org.study.pcfdevcert.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.study.pcfdevcert.domain.Taco;

public interface TacoRepository
        extends PagingAndSortingRepository<Taco, Long> {

}
