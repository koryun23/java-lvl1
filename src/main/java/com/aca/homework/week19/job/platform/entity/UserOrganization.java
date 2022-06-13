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

    @OneToOne
    @JoinColumn(name = "user_id",
            foreignKey = @ForeignKey(name = "FK_USER_ORGANIZATION_USER_ID_ID"),
            referencedColumnName = "id",
            nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "organization_id",
            foreignKey = @ForeignKey(name = "FK_USER_ORGANIZATION_ORGANIZATION_ID_ID"),
            referencedColumnName = "id",
            nullable = false
    )
    private Organization organization;

    public UserOrganization(){
    }

    public UserOrganization(User user, Organization organization) {
        this.user = user;
        this.organization = organization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                "user=" + user +
                ", organization=" + organization +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserOrganization userOrganization = (UserOrganization) o;
        return Objects.equals(id, userOrganization.id) && Objects.equals(organization, userOrganization.organization) && Objects.equals(user, userOrganization.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, organization);
    }
}
