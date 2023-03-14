package com.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.bo.ProjectEngineer;
import com.hibernate.entity.Project;
import com.hibernate.repository.ProjectRepository;

@RestController
@RequestMapping("project")
public class ProjectController {

	@Autowired
	private ProjectRepository projectRepository;
	
	@GetMapping
	public List<Project> getProject() {
		return projectRepository.findAll();
	}
	
	@PostMapping("add")
	public Project addProject(@RequestBody Project project) {
		return projectRepository.save(project);
	}
	
	@GetMapping("delete/{id}")
	public String deleteProject(@PathVariable(name = "id") int id) {
		projectRepository.deleteById(id);
		return "DONE";
	}
	
	@GetMapping("1")
	public List<ProjectEngineer> getProjectSpecificInfoWithJPQL() {
		return projectRepository.getProjectSpecificInfoWithJPQL();
	}
	
	
	@GetMapping("2")
	public String[] getProjectSpecificInfo() {
		return projectRepository.getProjectSpecificInfo();
	}
}
