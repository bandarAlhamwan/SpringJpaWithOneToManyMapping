package com.hibernate.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int projectId;
	private String name;
	private String projectCode;
	
	@OneToMany(cascade = CascadeType.ALL)
	//@OneToMany(cascade = CascadeType.PERSIST,orphanRemoval = true,fetch = FetchType.LAZY)
	@JoinColumn(name = "projectId_fk", referencedColumnName = "projectId")
	private List<Engineer> engineers;
}
