package com.Kofi.Contentservice.Repository;

import com.Kofi.Contentservice.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    <T> List<T> findByPost_Id(Long id, Class<T> type);
}
