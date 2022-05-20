package com.aca.classwork.week15.university.facade;

import com.aca.classwork.week15.university.entity.DiplomaColorType;

import java.time.LocalDate;
import java.util.List;

public class UserGraduationResponseDto {
    private String firstName;
    private String secondName;
    private LocalDate startDate;
    private LocalDate endDate;
    private DiplomaColorType colorType;
    private String diplomaId;

    private List<String> errors;

    public UserGraduationResponseDto(List<String> errors) {
        this.errors = errors;
    }
    public UserGraduationResponseDto(){
    }
    public UserGraduationResponseDto(String firstName, String secondName, LocalDate startDate, LocalDate endDate, DiplomaColorType colorType, String diplomaId) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.colorType = colorType;
        this.diplomaId = diplomaId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public DiplomaColorType getColorType() {
        return colorType;
    }

    public void setColorType(DiplomaColorType colorType) {
        this.colorType = colorType;
    }

    public String getDiplomaId() {
        return diplomaId;
    }

    public void setDiplomaId(String diplomaId) {
        this.diplomaId = diplomaId;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "UserGraduationResponseDto{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", colorType=" + colorType +
                ", diplomaId='" + diplomaId + '\'' +
                ", errors=" + errors +
                '}';
    }
}
