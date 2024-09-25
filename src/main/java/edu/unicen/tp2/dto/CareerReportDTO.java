package edu.unicen.tp2.dto;

import edu.unicen.tp2.schema.Career;

public class CareerReportDTO {
    
    private String careerName;
    private int year;
    private long enrolledCount;
    private long graduatedCount;

    public CareerReportDTO(String careerName, int year, long enrolledCount, long graduatedCount) {
        this.careerName = careerName;
        this.year = year;
        this.enrolledCount = enrolledCount;
        this.graduatedCount = graduatedCount;
    }

    // Getters y setters
    public String getCareer() {
        return careerName;
    }

    public void setCareer(String careerName) {
        this.careerName = careerName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getEnrolledCount() {
        return enrolledCount;
    }

    public void setEnrolledCount(long enrolledCount) {
        this.enrolledCount = enrolledCount;
    }

    public long getGraduatedCount() {
        return graduatedCount;
    }

    public void setGraduatedCount(long graduatedCount) {
        this.graduatedCount = graduatedCount;
    }

    @Override
    public String toString() {
        return "{" +
                "career=" + careerName +  // Asegúrate de que Career tenga un método getName()
                ", year=" + year +
                ", enrolledCount=" + enrolledCount +
                ", graduatedCount=" + graduatedCount +
                '}';
    }
}