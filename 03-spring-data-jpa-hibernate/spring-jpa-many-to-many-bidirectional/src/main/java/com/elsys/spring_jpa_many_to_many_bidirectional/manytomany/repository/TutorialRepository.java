package com.elsys.spring_jpa_many_to_many_bidirectional.manytomany.repository;

import java.util.List;

import com.elsys.spring_jpa_many_to_many_bidirectional.manytomany.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
  List<Tutorial> findByPublished(boolean published);

  List<Tutorial> findByTitleContaining(String title);
  
  List<Tutorial> findTutorialsByTagsId(Long tagId);
}
