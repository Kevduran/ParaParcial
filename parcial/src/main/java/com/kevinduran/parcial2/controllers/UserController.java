package com.kevinduran.parcial2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevinduran.parcial2.models.dtos.UserRegistrationDto;
import com.kevinduran.parcial2.models.entities.User;
import com.kevinduran.parcial2.services.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping(name = "/")
	public ResponseEntity<?> findAllbook(){
		List<User> users = userService.findall();
		return new ResponseEntity<>(
				users, HttpStatus.OK);
	}

	  
	  @PostMapping("/register")
	  public ResponseEntity<String> registerUser(@RequestBody UserRegistrationDto registrationDto) {
	      String username = registrationDto.getUsername();
	      String email = registrationDto.getEmail();
	      String password = registrationDto.getPassword();
	      
//	      // Verificar si el nombre de usuario o correo electrónico ya existen en la base de datos
//	      if (userService.existsByUsername(username)) {
//	          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El nombre de usuario ya está en uso");
//	      }
	      
//	      if (userService.existsByEmail(email)) {
//	          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El correo electrónico ya está en uso");
//	      }
	      
	      // Crear el objeto User y guardarlo en la base de datos
	      User newUser = new User(username, email, password);
	      userService.register(newUser);
	      
	      return ResponseEntity.ok("Usuario registrado exitosamente");
	  }
	  

}
