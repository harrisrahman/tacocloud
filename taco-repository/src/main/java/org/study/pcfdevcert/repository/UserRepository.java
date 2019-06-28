package org.study.pcfdevcert.repository;

import org.springframework.data.repository.CrudRepository;
import org.study.pcfdevcert.domain.User;

public interface UserRepository extends CrudRepository<User,Long> {
        User findByUsername(String username);
}
