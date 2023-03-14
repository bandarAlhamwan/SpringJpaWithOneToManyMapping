package com.hibernate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hibernate.bo.ProjectEngineer;
import com.hibernate.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>{

	
	@Query(value = "SELECT p.NAME , p.PROJECT_CODE , e.NAME , e.EMAIL FROM PROJECT p JOIN ENGINEER e ON p.PROJECT_ID = e.PROJECT_ID_FK", nativeQuery = true)
	public String[] getProjectSpecificInfo();
	
	@Query(value = "SELECT new com.hibernate.bo.ProjectEngineer(p.name, p.projectCode, e.name, e.email) FROM Project p JOIN p.engineers e")
	public List<ProjectEngineer> getProjectSpecificInfoWithJPQL();
}
