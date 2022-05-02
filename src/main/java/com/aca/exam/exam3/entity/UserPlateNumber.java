package com.aca.exam.exam3.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "USER_PLATE_NUMBERS")
public class UserPlateNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_PLATE_NUMBERS_ID_SEQUENCE")
    @SequenceGenerator(name = "USER_PLATE_NUMBERS_ID_SEQUENCE")
    private Long id;

    @Column(name = "plate_number")
    private String plateNumber;

    @ManyToOne
    @JoinColumn(name = "user_id",
            foreignKey = @ForeignKey(name = "USER_PLATE_NUMBERS_USER_ID_ID"),
            referencedColumnName = "id")
    private User user;

    public UserPlateNumber(){}
    public UserPlateNumber(String plateNumber, User user) {
        this.plateNumber = plateNumber;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPlateNumber that = (UserPlateNumber) o;
        return Objects.equals(id, that.id) && Objects.equals(plateNumber, that.plateNumber) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, plateNumber, user);
    }

    @Override
    public String toString() {
        return "UserPlateNumber{" +
                "id=" + id +
                ", plateNumber='" + plateNumber + '\'' +
                ", user=" + user +
                '}';
    }
}
