package com.aca.homework.week16.organization;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ORGANIZATIONS")
public class Organization {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "full_address", nullable = false)
    private String fullAddress;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Organization(String name, String fullAddress) {
        this.name = name;
        this.fullAddress = fullAddress;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return name.equals(that.name) && fullAddress.equals(that.fullAddress) && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, fullAddress, id);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "name='" + name + '\'' +
                ", fullAddress='" + fullAddress + '\'' +
                '}';
    }
}
