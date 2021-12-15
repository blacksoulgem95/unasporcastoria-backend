package com.unasporcastoria.core.api.repositories;

import com.unasporcastoria.core.api.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
}