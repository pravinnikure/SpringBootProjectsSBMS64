package com.app.restapi.service;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.app.restapi.repo.Repository;

public class RepoService 
{
	
	private Repository repository;

	public RepoService(Repository repository) {
		this.repository = repository;
	}
	
	public List<String> getDataLen(){
		
		try {
			return repository.getData().
					stream().
					filter(data -> data.length()<10).
					collect(Collectors.toList());
					
		} catch (SQLException e) {
			// TODO: handle exception
			return Arrays.asList();
		}
	}
	
	

}
