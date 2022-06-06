package com.aca.classwork.week15.university.entity;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Table(name = "USER_ROLE")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID",
            foreignKey = @ForeignKey(name = "FK_USER_ROLE_USER_ID"),
            nullable = false)
    private User user;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "TYPE", nullable = false, length = 50)
    private UserRoleType type;

    public UserRole() {
    }

    public UserRole(User user, UserRoleType type) {
        this.user = user;
        this.type = type;
    }
}
