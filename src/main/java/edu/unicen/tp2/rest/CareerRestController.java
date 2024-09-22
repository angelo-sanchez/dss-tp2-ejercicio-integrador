package edu.unicen.tp2.rest;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.unicen.tp2.dto.CareerInscriptsDTO;
import edu.unicen.tp2.services.CareerService;

@RestController
@RequestMapping("/careers")
public class CareerRestController {
    private CareerService careerService;

    CareerRestController(CareerService careerService) {
        // Agregamos las dependencias por constructor
        this.careerService = careerService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "getCareers") // Agregue el path extra porque sino /careers solo me da 404
    public List<CareerInscriptsDTO> getCareers() {
        return careerService.findCareersWithStudentCount();
    }
}
