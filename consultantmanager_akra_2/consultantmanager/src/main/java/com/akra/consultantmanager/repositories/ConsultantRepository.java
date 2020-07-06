package com.akra.consultantmanager.repositories;

import com.akra.consultantmanager.entities.Consultant;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultantRepository extends CrudRepository<Consultant, Long> {

    List<Consultant> findByName(String name);

}