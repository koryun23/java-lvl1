package com.aca.homework.week21.post.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

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



}
