package org.elsys.springjpaonetomanyunidirectional.hibernate.onetomany.repository;

import org.elsys.springjpaonetomanyunidirectional.hibernate.onetomany.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
