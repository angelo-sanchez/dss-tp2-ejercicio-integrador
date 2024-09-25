package edu.unicen.tp2.schema;

import java.time.LocalDateTime;

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

    @Column(name = "enrolled_date", nullable = false)
    private LocalDateTime enrolledDate ;

    @Column(name = "graduated_date", nullable = true)
    private LocalDateTime graduatedDate;

    @PrePersist
    protected void onCreate() {
        this.enrolledDate = LocalDateTime.now();
    }

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

    public LocalDateTime getEnrolledDate() {
        return enrolledDate;
    }

    public void setYearsEnrolled(LocalDateTime enrolledDate) {
        this.enrolledDate = enrolledDate;
    }

    public LocalDateTime getGraduated() {
        return graduatedDate;
    }

    public void setGraduated(LocalDateTime graduatedDate) {
        this.graduatedDate = graduatedDate;
    }

}