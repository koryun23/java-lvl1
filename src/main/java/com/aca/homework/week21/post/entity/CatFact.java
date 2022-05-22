package com.aca.homework.week21.post.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CAT_FACTS")
public class CatFact {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAT_FACT_ID_SEQUENCE")
    @SequenceGenerator(name = "CAT_FACT_ID_SEQUENCE")
    private Long id;

    @Column(name = "fact", nullable = false)
    private String fact;

    @Column(name = "length", nullable = false)
    private Integer length;

    public CatFact(Long id, String fact, Integer length) {
        this.id = id;
        this.fact = fact;
        this.length = length;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "CatFact{" +
                "id=" + id +
                ", fact='" + fact + '\'' +
                ", length=" + length +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatFact catFact = (CatFact) o;
        return Objects.equals(id, catFact.id) && Objects.equals(fact, catFact.fact) && Objects.equals(length, catFact.length);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fact, length);
    }
}
