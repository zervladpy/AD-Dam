package com.zervladpy.PracticaSpring1.Repositories;

import com.zervladpy.PracticaSpring1.Entities.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "gente", path ="gente")
public interface PersonaRepository extends PagingAndSortingRepository<Persona, Long> , CrudRepository<Persona, Long> {
    List<Persona> findBySurname(@Param("surname") String surname);

}
