package com.aca.homework.week19.job.platform.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "INVITATIONS")
public class Invitation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INVITATION_ID_SEQUENCE")
    @SequenceGenerator(name = "INVITATION_ID_SEQUENCE")
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(name = "FK_INVITATIONS_USER_ID_ID"),
            referencedColumnName = "id",
            nullable = false
    )
    private User user;

    @ManyToOne
    @JoinColumn(
            name = "organization_id",
            foreignKey = @ForeignKey(name = "FK_INVITATIONS_ORGANIZATION_ID_ID"),
            referencedColumnName = "id",
            nullable = false
    )
    private Organization organization;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", nullable = false)
    private InvitationStatusType status;

    public Invitation() {
    }

    public Invitation(User user, Organization organization, InvitationStatusType status) {
        this.user = user;
        this.organization = organization;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public InvitationStatusType getStatus() {
        return status;
    }

    public void setStatus(InvitationStatusType status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invitation that = (Invitation) o;
        return Objects.equals(id, that.id) && Objects.equals(user, that.user) && Objects.equals(organization, that.organization) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, organization, status);
    }

    @Override
    public String toString() {
        return "Invitation{" +
                "id=" + id +
                ", user=" + user +
                ", organization=" + organization +
                ", status=" + status +
                '}';
    }
}
