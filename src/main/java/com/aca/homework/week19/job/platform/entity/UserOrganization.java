package com.aca.homework.week19.job.platform.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "USER_ORGANIZATION")
public class UserOrganization {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ORGANIZATION_ID_SEUENCE")
    @SequenceGenerator(name = "USER_ORGANIZATION_ID_SEQUENCE")
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "second_name", nullable = false)
    private String secondName;

    @ManyToOne
    @JoinColumn(name = "organization_id",
            foreignKey = @ForeignKey(name = "FK_USER_ORGANIZATION_ORGANIZATION_ID_ID"),
            referencedColumnName = "id",
            nullable = false
    )
    private Organization organization;

    public UserOrganization(){
    }

    public UserOrganization(String firstName, String secondName, Organization organization) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.organization = organization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", organization=" + organization +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserOrganization user = (UserOrganization) o;
        return Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(secondName, user.secondName) && Objects.equals(organization, user.organization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName, organization);
    }
}
