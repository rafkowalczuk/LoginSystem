package pl.kowalczuk.ownapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import pl.kowalczuk.ownapp.role.Role;
import pl.kowalczuk.ownapp.role.RoleRepository;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class OwnappApplication {

	public static void main(String[] args) {
		SpringApplication.run(OwnappApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(RoleRepository roleRepository){
		return args -> {
if(roleRepository.findByName("USER").isEmpty()){
	roleRepository.save(
			Role.builder().name("USER").build()
	);
}
		};
	};
}
