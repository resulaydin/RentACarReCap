package hardworking.io.rentACarReCap;

import java.util.HashMap;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import hardworking.io.rentACarReCap.core.utilities.exceptions.BusinessException;
import hardworking.io.rentACarReCap.core.utilities.exceptions.ProblemDetails;
import hardworking.io.rentACarReCap.core.utilities.exceptions.ValidationProblemDetails;

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

	/*
	 * Fırlattığım exception eğer burada yakalanıp özelliştirilmezse son kullanıcıya
	 * çok büyük bir mesajj ile göndeririz. Bu yüzden burada yakalayıp bu mesajı
	 * özelleştireceğiz ve bir nesne olarak geri değer döndereceğiz.
	 * <ProblemDetails> nesnesi içinde mesaj field var.
	 * 
	 * AAA -> ile bütün hataları yakalamamızı sağlar middleware gibi BBB -> ile
	 * hangi tür hatalar yakalanacak incelenmektedir.
	  	
	 * Eğer kullanıcıları doğru bilgilendirmek istersek herbir hata için bir metod yazıllmalıdır
	   Ancak eğer genel bir mesaj döndürülecekse bütün hataların atası olan "Exception" Sınıfını Arguman
	   olarak alacak genel bir method yazılabiir.
	 
	 */

	@ExceptionHandler
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException) {
		ProblemDetails problemDetails=new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		return problemDetails;
	}
	
	
	@ExceptionHandler
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ProblemDetails handleValidationException(MethodArgumentNotValidException metodException) {
		ValidationProblemDetails validationProblemDetails=new ValidationProblemDetails();
		validationProblemDetails.setMessage("Validation.Exception");
		validationProblemDetails.setValidationErrors(new HashMap<String,String>());
		
		for (FieldError fieldError : metodException.getBindingResult().getFieldErrors()) {
			validationProblemDetails.getValidationErrors()
			.put(fieldError.getField(),fieldError.getDefaultMessage());
		}
		
		return validationProblemDetails;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
