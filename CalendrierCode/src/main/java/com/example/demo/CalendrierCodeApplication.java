package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.entities.ChefDepartement;
import com.example.demo.entities.JwtRole;
import com.example.demo.entities.JwtUser;
import com.example.demo.model.JwtERole;
import com.example.demo.repository.JwtRoleRepository;
import com.example.demo.repository.JwtUserRepository;

@SpringBootApplication
public class CalendrierCodeApplication {

	@Autowired
	JwtUserRepository jwtUserRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	JwtRoleRepository jwtRoleRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CalendrierCodeApplication.class, args);
	}
	@Bean
	public CommandLineRunner init(JwtRoleRepository jwtRoleRepository) {

		return new CommandLineRunner() {
			public void run(String... strings) throws Exception {
				
				if(jwtRoleRepository.findAll().size() == 0)
				{
					jwtRoleRepository.save(new JwtRole(JwtERole.ROLE_ETUDIANT));
					jwtRoleRepository.save(new JwtRole(JwtERole.ROLE_ENSEIGNANT));
					jwtRoleRepository.save(new JwtRole(JwtERole.ROLE_PARENT));
					jwtRoleRepository.save(new JwtRole(JwtERole.ROLE_ENTREPRISE));
					jwtRoleRepository.save(new JwtRole(JwtERole.ROLE_CHEFDEPARTEMENT));
					  
					
				}
			
				if(jwtUserRepository.findAll().size()==0)
				{
					Set<JwtRole> roles = new HashSet<JwtRole>();
					JwtRole adminRole = jwtRoleRepository.findByname(JwtERole.ROLE_CHEFDEPARTEMENT);
					roles.add(adminRole);

					JwtUser user=new ChefDepartement("chef", "chef", "chef", "chef", "chef", "chef","chef");
					

					user.setPassword(
					 encoder.encode("chef"));
					
					user.setRoles(roles);
					
					jwtUserRepository.save(user);
				}

				
				
			}
		};
	}
}
