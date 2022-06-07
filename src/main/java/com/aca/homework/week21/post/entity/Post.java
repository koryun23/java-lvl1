package com.aca.homework.week21.post.entity;

import org.springframework.util.Assert;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "POSTS")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POST_ID_SEQUENCE")
    @SequenceGenerator(name = "POST_ID_SEQUENCE")
    private Long id;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "content", nullable = false, length = 500)
    private String content;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    public Post(){
    }

    public Post(LocalDateTime creationDate, String content, String createdBy) {
        Assert.notNull(creationDate, "creation date should not be null");
        Assert.notNull(content, "Cat fact content should not be null");
        Assert.hasText(content, "Cat fact content should not be null");
        Assert.notNull(createdBy, "The string representing the creator of the post should not be null");
        Assert.hasText(createdBy, "The string representing the creator of the post should not be empty");
        this.creationDate = creationDate;
        this.content = content;
        this.createdBy = createdBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(content, post.content) && Objects.equals(createdBy, post.createdBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, createdBy);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
