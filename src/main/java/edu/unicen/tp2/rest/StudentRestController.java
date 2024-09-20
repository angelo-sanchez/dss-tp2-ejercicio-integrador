package edu.unicen.tp2.rest;

import edu.unicen.tp2.repository.StudentsRepository;
import edu.unicen.tp2.schema.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentRestController {
    @Autowired
    private StudentsRepository studentsRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getStudents() {
        return studentsRepository.findAllOrderBy("documentNumber");
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addStudents() {
        Student st;
        st = new Student();
        st.setFirstName("Juan");
        st.setLastName("Perez");
        st.setAge(20);
        st.setDocumentNumber("12345678");
        st.setGender("Male");
        st.setCityOfResidence("Rosario");
        st.setUniversityBookNumber("123456");
        studentsRepository.save(st);

        st = new Student();
        st.setFirstName("Maria");
        st.setLastName("Perez");
        st.setAge(18);
        st.setDocumentNumber("654654654");
        st.setGender("Female");
        st.setCityOfResidence("Rosario");
        st.setUniversityBookNumber("2335465465");
        studentsRepository.save(st);

        st = new Student();
        st.setFirstName("Luis");
        st.setLastName("Rodriguez");
        st.setAge(15);
        st.setDocumentNumber("001321354687");
        st.setGender("Male");
        st.setCityOfResidence("Buenos Aires");
        st.setUniversityBookNumber("00654654654");
        studentsRepository.save(st);
    }
}
