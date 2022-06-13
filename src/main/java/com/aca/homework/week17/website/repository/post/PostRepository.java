package com.aca.homework.week17.website.repository.post;

import com.aca.homework.week17.website.entity.Post;
import com.aca.homework.week17.website.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByUserId(Long id);

    boolean existsById(Long id);
}
