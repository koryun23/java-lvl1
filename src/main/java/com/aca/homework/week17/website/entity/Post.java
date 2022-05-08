package com.aca.homework.week17.website.entity;

import com.aca.homework.week17.website.facade.post.dto.ImageDto;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "POSTS")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POST_ID_SEQUENCE")
    @SequenceGenerator(name = "POST_ID_GENERATOR")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_POST_USER_ID_ID"), referencedColumnName = "id")
    private User user;
    public Post() {
    }
    public Post(String title, String description, User user) {
        setTitle(title);
        setDescription(description);
        setUser(user);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        Assert.notNull(id, "id should not be null");
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        Assert.notNull(title, "title should not be null");
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        Assert.notNull(description, "description should not be null");
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        Assert.notNull(user, "user should not be null");
        this.user = user;
    }
}
