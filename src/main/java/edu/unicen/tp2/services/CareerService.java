package edu.unicen.tp2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unicen.tp2.dto.CareerInscriptsDTO;
import edu.unicen.tp2.repository.CarreerRepository;

@Service
public class CareerService {
    @Autowired
    private CarreerRepository carreerRepository;

    public List<CareerInscriptsDTO> findCareersWithStudentCount(){
        return carreerRepository.findCareersWithStudentCount();
    }

}
