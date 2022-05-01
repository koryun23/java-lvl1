package com.aca.classwork.week15.university.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "DIPLOMA")
public class Diploma {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "color", nullable = false, length = 25)
    @Enumerated(value = EnumType.STRING)
    private DiplomaColorType colorType;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_data", nullable = false)
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_DIPLOMA_USER_ID_ID"))
    private User user;

    public Diploma(){}

    public Diploma(DiplomaColorType colorType, LocalDate startDate, LocalDate endDate, User user) {
        this.colorType = colorType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DiplomaColorType getColorType() {
        return colorType;
    }

    public void setColorType(DiplomaColorType colorType) {
        this.colorType = colorType;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
