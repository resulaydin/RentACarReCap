package hardworking.io.rentACarReCap;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@SpringBootApplication
@RestControllerAdvice
public class RentACarReCapApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarReCapApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	

}
