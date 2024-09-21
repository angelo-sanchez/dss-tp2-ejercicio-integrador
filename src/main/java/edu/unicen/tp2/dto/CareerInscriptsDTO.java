
package edu.unicen.tp2.dto;

import edu.unicen.tp2.schema.Career;

public class CareerInscriptsDTO {
    private Career career;
    private long enrolledCount;

    public CareerInscriptsDTO(Career career, long enrolledCount) {
        this.career = career;
        this.enrolledCount = enrolledCount;
    }

    public Career getCareer() {
        return career;
    }

    public void setCareer(Career career) {
        this.career = career;
    }

    public long getEnrolledCount() {
        return enrolledCount;
    }

    public void setEnrolledCount(long enrolledCount) {
        this.enrolledCount = enrolledCount;
    }
}