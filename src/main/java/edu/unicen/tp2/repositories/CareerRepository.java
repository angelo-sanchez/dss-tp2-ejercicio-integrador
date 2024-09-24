package edu.unicen.tp2.repositories;

import java.util.List;

import edu.unicen.tp2.dto.CareerInscriptsDTO;
import edu.unicen.tp2.schema.Career;

public interface CareerRepository {
    public Career findById(long id);

    public List<CareerInscriptsDTO> findCareersWithStudentCount();
}
