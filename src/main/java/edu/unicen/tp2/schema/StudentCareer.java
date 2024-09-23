package edu.unicen.tp2.schema;

import jakarta.persistence.*;

@Entity
@Table(name = "student_careers")
public class StudentCareer {
    @EmbeddedId
    private StudentCareerId id;

    @MapsId("studentId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @MapsId("careerId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "career_id", nullable = false)
    private Career career;

    @Column(name = "years_enrolled", nullable = false)
    private Integer yearsEnrolled;

    @Column(name = "graduated", nullable = false)
    private Boolean graduated = false;

    public StudentCareerId getId() {
        return id;
    }

    public void setId(StudentCareerId id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Career getCareer() {
        return career;
    }

    public void setCareer(Career career) {
        this.career = career;
    }

    public Integer getYearsEnrolled() {
        return yearsEnrolled;
    }

    public void setYearsEnrolled(Integer yearsEnrolled) {
        this.yearsEnrolled = yearsEnrolled;
    }

    public Boolean getGraduated() {
        return graduated;
    }

    public void setGraduated(Boolean graduated) {
        this.graduated = graduated;
    }

}