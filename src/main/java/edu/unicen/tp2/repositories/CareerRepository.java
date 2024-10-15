package edu.unicen.tp2.repositories;

import java.util.List;

import edu.unicen.tp2.dto.CareerInscriptsDTO;
import edu.unicen.tp2.dto.CareerReportDTO;
import edu.unicen.tp2.schema.Career;

public interface CareerRepository extends BaseRepository<Career, Long> {
    List<CareerInscriptsDTO> findCareersWithStudentCount();
    List<CareerReportDTO> reportCareerWithStudentsInfo();
}
