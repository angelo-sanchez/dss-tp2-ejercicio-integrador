package edu.unicen.tp2.services;

import java.util.List;

import edu.unicen.tp2.dto.CareerInscriptsDTO;
import edu.unicen.tp2.dto.CareerReportDTO;
import edu.unicen.tp2.repositories.CareerRepository;

/**
 * CareerService
 */
public class CareerService {

    private CareerRepository carreerRepository;

    public CareerService(CareerRepository carreerRepository) {
        this.carreerRepository = carreerRepository;
    }

    public List<CareerInscriptsDTO> findCareersWithStudentCount(){
        return carreerRepository.findCareersWithStudentCount();
    }

    public List<CareerReportDTO> reportCareerWithStudentsInfo(){
        return carreerRepository.reportCareerWithStudentsInfo();
    }
}