package hardworking.io.rentACarReCap.core.utilities.exceptions;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationProblemDetails extends ProblemDetails {
	
	/*
		  AAA ->  " MethodArgumentNotValidException" metodu içerisinde hata data' sı bulunamaktadır.
		  		  Bu data içerisinde ilgili entity' ler içerisindeki herbir property'nin kuralları için
		  		  hatalar bulunmaktadır. Dolayısıyla <key,value> şeklinde field - hata ikilisi bulunmaktadır.
		  		  Bu yüzden Map<String,String> nesnesi oluşturuldu.
	 */
	
	private Map<String, String> validationErrors;

}
