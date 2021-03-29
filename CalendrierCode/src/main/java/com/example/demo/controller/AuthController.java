package com.example.demo.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Enseignant;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.JwtRole;
import com.example.demo.entities.JwtUser;
import com.example.demo.model.JwtERole;
import com.example.demo.model.JwtResponse;
import com.example.demo.model.JwtUserDetails;
import com.example.demo.model.LoginRequest;
import com.example.demo.model.MessageResponse;
import com.example.demo.model.SignupRequest;
import com.example.demo.repository.JwtRoleRepository;
import com.example.demo.repository.JwtUserRepository;
import com.example.demo.security.JwtUtils;

 

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtUserRepository jwtUserRepository;

	@Autowired
	JwtRoleRepository jwtRoleRepository;


	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;



	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser( @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		JwtUserDetails userDetails = (JwtUserDetails) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												userDetails.getUsername(), 
												 roles));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser( @RequestBody SignupRequest signUpRequest) {
		if (jwtUserRepository.existsByUserName(signUpRequest.getUserName())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

	 JwtUser user=null;
	 JwtRole role=null;

		String strRole = signUpRequest.getRole();
		Set<JwtRole> roles = new HashSet<>();

	
			switch (strRole.toLowerCase()) {
			case "enseignant":	
				role = jwtRoleRepository.findByName(JwtERole.ROLE_ENSEIGNANT)
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				roles.add(role);
				user= new Enseignant();
				break;
				case "etudiant":	
					
					role = jwtRoleRepository.findByName(JwtERole.ROLE_ETUDIANT)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(role);
					user=new Etudiant();
					break;
					
				case "entreprise":
					
					role = jwtRoleRepository.findByName(JwtERole.ROLE_ENTREPRISE)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(role);
					user=new JwtUser();
					break;
					
				case "parent":

					role = jwtRoleRepository.findByName(JwtERole.ROLE_PARENT)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(role);
					user=new JwtUser();
					break;
			
				default:
					return ResponseEntity
							.badRequest()
							.body(new MessageResponse("Error: role needed "));
					
				}
			
		user.setEmailUser(signUpRequest.getUserName());
		user.setUserName(signUpRequest.getUserName());
		user.setNomUser(signUpRequest.getNom());
		user.setPrenomUser(signUpRequest.getPrenom());
		user.setTelUser(signUpRequest.getTel());
		user.setGroupe(signUpRequest.getGroupe());
		
		user.setPassword(
		 encoder.encode(signUpRequest.getPassword()));
		user.setRoles(roles);
		
		jwtUserRepository.save(user);

		
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

}
