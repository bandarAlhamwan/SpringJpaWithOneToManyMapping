package com.hibernate;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hibernate.entity.Engineer;
import com.hibernate.entity.Project;
import com.hibernate.repository.ProjectRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class SpringJpaWithOneToManyMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaWithOneToManyMappingApplication.class, args);
	}
	
	
	@Autowired
	ProjectRepository repo;
	
	@PostConstruct
	public void init() {
		
		for (int i = 1; i < 3; i++) {
			
			List<Engineer> engineers = Arrays.asList(
					new Engineer( "engineer"+i, "dept"+i, i+"@gmail.com"),
					new Engineer("engineer"+i, "dept"+i, i+"@gmail.com")
					);
			
			Project project = new Project(i, "Project"+i, "Code"+i, engineers);
			repo.save(project);
		}

	}

}
