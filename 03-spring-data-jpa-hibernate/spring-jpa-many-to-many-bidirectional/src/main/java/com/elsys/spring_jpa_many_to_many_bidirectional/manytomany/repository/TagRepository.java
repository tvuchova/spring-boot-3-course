package com.elsys.spring_jpa_many_to_many_bidirectional.manytomany.repository;

import java.util.List;

import com.elsys.spring_jpa_many_to_many_bidirectional.manytomany.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TagRepository extends JpaRepository<Tag, Long> {
  List<Tag> findTagsByTutorialsId(Long tutorialId);
}
