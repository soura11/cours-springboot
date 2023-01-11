package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Project;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.services.IProjectService;

@Service("projectService")
public class ProjectServiceImpl implements IProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;

	public ProjectServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Project> findAll() {
		// TODO Auto-generated method stub
		return projectRepository.findAll();
	}

	@Override
	public Project saveOrUpdate(Project o) {
		// TODO Auto-generated method stub
		return projectRepository.save(o);
	}

	@Override
	public Optional<Project> findById(long id) {
		// TODO Auto-generated method stub
		return projectRepository.findById(id);
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		projectRepository.deleteById(id);
		return true;
	}

	@Override
	public List<Project> getProjectsByPersonId(long idPerson) {
		// TODO Auto-generated method stub
		return projectRepository.findProjectByPersonsId(idPerson);
	}

}
