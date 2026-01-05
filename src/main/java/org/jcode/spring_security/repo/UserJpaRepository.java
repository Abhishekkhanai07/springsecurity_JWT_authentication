package org.jcode.spring_security.repo;

import org.jcode.spring_security.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<Users,String>{

}
