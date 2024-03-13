package com.zervladpy.springperson;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByNameStartsWithIgnoreCase(@Param("name") String name);
    List<Person> findBySurnameStartsWithIgnoreCase(@Param("surname") String surname);
}
