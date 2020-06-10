package com.main.StructuredSchedule.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.StructuredSchedule.Enums.UserType;
import com.main.StructuredSchedule.configObject.ConfigLinksObject;
import com.main.StructuredSchedule.models.Role;
import com.main.StructuredSchedule.models.User;
import com.main.StructuredSchedule.services.UserServiceImpl;
import com.main.StructuredSchedule.util.JwtUtil;

@RestController
public class AuthenticateRestController {
	
	@Autowired
    private JwtUtil jwtUtil;
	
	@Autowired
	ConfigLinksObject configLinks;
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	
    @Autowired
    private AuthenticationManager authenticationManager;
    
    Logger logger = LoggerFactory.getLogger(AuthenticateRestController.class);



    @PostMapping("/authenticate")
    public ResponseEntity<?> generateToken(@RequestBody User user) throws Exception {
    	
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
	
            
            user = userServiceImpl.findByEmail(user.getEmail());
            HttpHeaders responseHeaders = new HttpHeaders();
        	EntityModel<User> entityModel = new EntityModel<User>(user);
            
             UserType userType = user.getUserType();
            
             if(userType == UserType.PRODUCER)
             {
            	 entityModel.add(configLinks.getUserProducerLinks(user));

             }
             else if(userType == UserType.CONSUMER) {
            	 entityModel.add(configLinks.getUserСonsumerLinks(user)); 	
             }
    
            	
              
             
             
        
            	
            
            
            responseHeaders.setBearerAuth(jwtUtil.generateToken(user.getEmail()));
            return new ResponseEntity<EntityModel<User>>(entityModel,responseHeaders , HttpStatus.OK);
            
        } catch (Exception ex) {
        	logger.warn("Exception");
        	return new ResponseEntity<String>( ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
       
        
    }

    

    
}
