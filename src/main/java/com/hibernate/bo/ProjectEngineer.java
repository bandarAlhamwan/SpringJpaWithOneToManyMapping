package com.hibernate.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectEngineer {

	
	private String projectName;
	private String projectCode;
	private String engineerName;
	private String email;
}
