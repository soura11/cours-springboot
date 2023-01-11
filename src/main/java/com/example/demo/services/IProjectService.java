package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Project;

public interface IProjectService extends IService<Project>{
	
	List<Project> getProjectsByPersonId(long idPerson);

}
