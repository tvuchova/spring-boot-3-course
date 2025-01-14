package com.elsys.spring_jpa_entity_manager.spring.jpa.entitymanager;

import java.util.ArrayList;
import java.util.List;

import com.elsys.spring_jpa_entity_manager.spring.jpa.entitymanager.model.Tutorial;
import com.elsys.spring_jpa_entity_manager.spring.jpa.entitymanager.repository.TutorialRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaEntitymanagerApplication implements CommandLineRunner {

	@Autowired
	TutorialRepository tutorialRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaEntitymanagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		tutorialRepository.deleteAll();
		tutorialRepository.save(new Tutorial("Spring Data", "Tut#1 Description", false));
		tutorialRepository.save(new Tutorial("Java Spring", "Tut#2 Description", false));
		tutorialRepository.save(new Tutorial("Hibernate", "Tut#3 Description", false));
		tutorialRepository.save(new Tutorial("Spring Boot", "Tut#4 Description", false));
		tutorialRepository.save(new Tutorial("Spring Data JPA", "Tut#5 Description", false));
		tutorialRepository.save(new Tutorial("JPA EntityManager", "Tut#6 Description", false));
		tutorialRepository.save(new Tutorial("Spring Security", "Tut#7 Description", false));
		List<Tutorial> tutorials = new ArrayList<>();
		tutorials = tutorialRepository.findAll();
		show(tutorials);

		Tutorial tutorial = tutorialRepository.findById(6);
        System.out.println(tutorial);

		Tutorial tut1 = tutorials.get(0);
        tut1.setPublished(true);
        Tutorial tut3 = tutorials.get(2);
        tut3.setPublished(true);
        Tutorial tut5 = tutorials.get(4);
        tut5.setPublished(true);
        tutorialRepository.update(tut1);
        tutorialRepository.update(tut3);
        tutorialRepository.update(tut5);

        tutorials = tutorialRepository.findByTitleContaining("jpa");
        show(tutorials);

		tutorials = tutorialRepository.findByPublished(true);
		show(tutorials);

		tutorials = tutorialRepository.findByTitleAndPublished("data", true);
		show(tutorials);

		Tutorial deletedTutorial = tutorialRepository.deleteById(4);
		System.out.println(deletedTutorial);

		tutorials = tutorialRepository.findAll();
        show(tutorials);

		int numberOfDeletedRows = tutorialRepository.deleteAll();
		System.out.println(numberOfDeletedRows);

		tutorials = tutorialRepository.findAll();
		show(tutorials);
	}

	private void show(List<Tutorial> tutorials) {
		System.out.println("Number of Items: " + tutorials.size());
		tutorials.forEach(System.out::println);
	  }

}
