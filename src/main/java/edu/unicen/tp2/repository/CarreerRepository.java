package edu.unicen.tp2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.unicen.tp2.schema.Career;


@Repository
public interface CarreerRepository extends JpaRepository<Career, Long>{
    
}
