package com.aca.homework.week21.post.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POST_ID_SEQUENCE")
    @SequenceGenerator(name = "POST_ID_SEQUENCE")
    private Long id;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    @OneToOne
    @JoinColumn(name = "content_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "POST_CONTENT_ID_CAT_FACT_ID"),
            referencedColumnName = "id")
    private CatFact fact;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    public Post(){
    }

    public Post(LocalDateTime creationDate, CatFact fact, String createdBy) {
        this.creationDate = creationDate;
        this.fact = fact;
        this.createdBy = createdBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public CatFact getFact() {
        return fact;
    }

    public void setFact(CatFact fact) {
        this.fact = fact;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(creationDate, post.creationDate) && Objects.equals(fact, post.fact) && Objects.equals(createdBy, post.createdBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creationDate, fact, createdBy);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", fact=" + fact +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
