package com.op.mongo.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.op.mongo.entity.User;



@Configuration

public class UserAudtiting implements AuditorAware<String>{

    @Override
    public Optional<String> getCurrentAuditor() {
    	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    
    	
    	if (principal instanceof UserDetails) {
    		  String username = ((UserDetails)principal).getUsername();
    		
    		  return Optional.of(username);
    		} else {
    		  String username = principal.toString();
    		  System.out.println("usen name " +username);
    		  return Optional.of(username);
    		}
    	//String uname = SecurityContextHolder.getContext().getAuthentication().getName();
        //return Optional.of(username);
        
    }
}
