package com.steven.prueba.symplifica.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.steven.prueba.symplifica.model.User;
import com.steven.prueba.symplifica.service.UserService;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;


@RestController
@Controller
@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping("/new-user")
	public ResponseEntity<Object> saveClient(@RequestBody String jsonString) { // Crea o edita cliente
		
		try {
			ObjectMapper objMapper = new ObjectMapper();
			JsonNode jNode = objMapper.readTree(jsonString);
			
			User user = new User();
			user.setName(jNode.get("user").get("name").asText());
			user.setLastName(jNode.get("user").get("lastName").asText());
			user.setEmail(jNode.get("user").get("email").asText());
			User newUser = userService.saveUser(user); 
			return new ResponseEntity<> (newUser, HttpStatus.CREATED);
		} catch (JsonMappingException ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\": \"Json error\"}");
		} catch (JsonProcessingException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\": \"Json error\"}");
		} catch (ConstraintViolationException ex) {
			String message = " - ";
			
			ConstraintViolationException violationExcep = (ConstraintViolationException) ex;
            Set<ConstraintViolation<?>> violations = violationExcep.getConstraintViolations();

            for (ConstraintViolation<?> violation : violations) {
                message += violation.getMessage() + " - ";
            }
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\": \"" + message + "\"}");
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\": \"" + "Unknown error" + "\"}");
		}
			
	}
	
	@DeleteMapping("/delete-user/{id}")
    public ResponseEntity<Object> deleteResource(@PathVariable Integer id) {
		Boolean deleted = userService.deleteUserById(id);
		if (deleted.booleanValue()) {
			return ResponseEntity.status(HttpStatus.OK).body("{\"result\": \"" + "User deleted" + "\"}");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\": \"" + "Error deleting user" + "\"}");
		}
		
    }
	
	@GetMapping("/list-users")
	public ResponseEntity<Object> getUsers(){
		List<User> users = userService.getUsers();
		return ResponseEntity.status(HttpStatus.OK).body(users);
		
	}
	
}
