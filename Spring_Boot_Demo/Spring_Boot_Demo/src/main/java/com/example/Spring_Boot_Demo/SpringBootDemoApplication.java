package com.example.Spring_Boot_Demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.example.Spring_Boot_Demo.Beans.Git_User;

import org.springframework.http.*;

import java.util.Collections;


@SpringBootApplication
public class SpringBootDemoApplication implements CommandLineRunner {
	//@Autowired 
	Git_User gitUser;
	public static void main(String[] args)  {
		SpringApplication.run(SpringBootDemoApplication.class, args);
		
	}
	
	@Override
	public void run(String... args) throws Exception {
		RestTemplate restTemplate= new RestTemplate();
		HttpHeaders headers=new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		String resourceURL= "https://api.github.com/users/octocat/followers";
		HttpEntity<List<Git_User>>entity= new HttpEntity<List<Git_User>>(headers);
		ResponseEntity <Git_User[]> response =restTemplate.exchange(resourceURL,HttpMethod.GET,entity,Git_User[].class);
		
		if(response.getStatusCode()==HttpStatus.OK) 
		{
			//logic to retrieve 5 followers from the Apiendpoint
			int i =0;
			for(Git_User gituser:response.getBody()) {
					if(i<5) {
						System.out.println(gituser.followers_url +  ", " +gituser.login);
						getFollowers(restTemplate,gituser.followers_url, entity,1);						
						i++;
					}
					
			}
		   System.out.println(response);
		}
		
		else		
		{
			System.out.println("Error");
		}
		
	}
	
	private void getFollowers(RestTemplate restTemplate,String url, HttpEntity<List<Git_User>> entity, int deepLevel) {
		ResponseEntity <Git_User[]> response =restTemplate.exchange(url,HttpMethod.GET,entity,Git_User[].class);
		//logic to retrieve 3 levels
		if(deepLevel>3) {
			return;
		}
		
		if(response.getStatusCode()==HttpStatus.OK) 
		{
			int intDeepLevel = deepLevel+1;
			int i=0;
			for(Git_User gituser:response.getBody()) {
				if(i<5) {
					getFollowers(restTemplate,gituser.followers_url, entity,intDeepLevel);
					System.out.println(gituser.followers_url +  ", " +gituser.login);
					i++;
				}
					
			}
		   System.out.println(response);
		}
		
		else {
			System.out.println("followers doesnt exist");
			}
	}
	

	}
