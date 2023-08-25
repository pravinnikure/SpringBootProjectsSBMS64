package com.app.restapi;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.app.restapi.repo.Repository;
import com.app.restapi.service.RepoService;

@ExtendWith(MockitoExtension.class)
public class ServiceTest
{
	
	@Mock
	Repository repository;
	@InjectMocks
	RepoService service;
	
	@Test
	@Order(2)
	@DisplayName("Success Test")
	void repoSuccess()
	{
		//set up mockito process 
		
		try {
			
			Mockito.when(repository.getData()).
			             thenReturn(
			            		Arrays.asList("A","B","data","MODEL","12345","33","MN")
					);
			
		} catch (Exception e) 
		{
			e.printStackTrace();
			// TODO: handle exception
		}
		
		List<String> list = service.getDataLen();
		
		//validation result
		Assertions.assertNotNull(list);
		
		Assertions.assertEquals(4, list.size());
	
	}
	
	@Test
	@Order(1)
	@DisplayName("Failed Test")
	void testFailure()
	{
		try {
			
			Mockito.when(repository.getData()).thenThrow(new SQLException("Connection Error"));
			
		} catch (Exception e) 
		{
			e.printStackTrace();
			// TODO: handle exception
		}
		
		List<String> list = service.getDataLen();
		
		
		Assertions.assertNotNull(list);   //Empty list is created
		Assertions.assertEquals(0, list.size());
	}
}
