package com.elsys.spring_jpa_entity_manager.spring.jpa.entitymanager.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tutorials")
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "published")
    private Boolean published;

    public Tutorial() {
        
    }

    public Tutorial(String title,String description,Boolean published) {
        this.title=title;
        this.description=description;
        this.published=published;
    }

    public long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.title=description;
    }

    public Boolean isPublished(){
        return published;
    }

    public void setPublished(boolean isPublished) {
        this.published = isPublished;
    }
    
    @Override
    public String toString(){
        return "Tutorial [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + "]";
    }    
    
}
