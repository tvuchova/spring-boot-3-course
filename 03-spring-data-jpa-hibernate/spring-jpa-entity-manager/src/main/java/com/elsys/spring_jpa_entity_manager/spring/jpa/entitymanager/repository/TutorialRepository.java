package com.elsys.spring_jpa_entity_manager.spring.jpa.entitymanager.repository;

import java.util.List;

import com.elsys.spring_jpa_entity_manager.spring.jpa.entitymanager.model.Tutorial;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class TutorialRepository {

    @PersistenceContext
    private EntityManager entityManager;
       
   public List<Tutorial> findByTitleContaining(String title) {
   TypedQuery<Tutorial> query = entityManager.createQuery(
   "SELECT t FROM Tutorial t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%', :title,'%'))",
   Tutorial.class);
   return query.setParameter("title", title).getResultList();
  }
  public List<Tutorial> findByPublished(boolean isPublished) {
    TypedQuery<Tutorial> query = entityManager.createQuery(
    "SELECT t FROM Tutorial t WHERE t.published=:isPublished",
    Tutorial.class);
    return query.setParameter("isPublished", isPublished).getResultList();
  }

  public List<Tutorial> findByTitleAndPublished(String title, boolean isPublished) {
    TypedQuery<Tutorial> query = entityManager.createQuery(
    "SELECT t FROM Tutorial t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%', :title,'%')) AND t.published=:isPublished",
    Tutorial.class);
    return query.setParameter("title", title).setParameter("isPublished", isPublished).getResultList();
  }

    @Transactional
    public Tutorial save(Tutorial tutorial) {
      entityManager.persist(tutorial);
      return tutorial;
    }   

    public Tutorial findById(long id) {
        Tutorial tutorial = (Tutorial) entityManager.find(Tutorial.class, id);
        return tutorial;
    }

    public List<Tutorial> findAll() {
      TypedQuery<Tutorial> query=entityManager.createQuery("SELECT t FROM Tutorial t", Tutorial.class);
      return query.getResultList();
  }

    @Transactional
    public Tutorial update(Tutorial tutorial) {
      entityManager.merge(tutorial);
      return tutorial;
    }

    @Transactional
    public Tutorial deleteById(long id) {
      Tutorial tutorial = findById(id);
      if (tutorial != null) {
         entityManager.remove(tutorial);
      }
      return tutorial;
    }

    @Transactional
    public int deleteAll() {
       Query query = entityManager.createQuery("DELETE FROM Tutorial");
       return query.executeUpdate();
    }    
}
