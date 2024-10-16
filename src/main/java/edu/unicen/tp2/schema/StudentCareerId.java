package edu.unicen.tp2.schema;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class StudentCareerId implements java.io.Serializable {
    private static final long serialVersionUID = -6808444411136438155L;
    @Column(name = "student_id", nullable = false)
    private Long studentId;

    @Column(name = "career_id", nullable = false)
    private Long careerId;

    public StudentCareerId(Long studentId, Long careerId) {
        this.studentId = studentId;
        this.careerId = careerId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCareerId() {
        return careerId;
    }

    public void setCareerId(Long careerId) {
        this.careerId = careerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        StudentCareerId entity = (StudentCareerId) o;
        return Objects.equals(this.studentId, entity.studentId) &&
               Objects.equals(this.careerId, entity.careerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, careerId);
    }

}