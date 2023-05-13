package hardworking.io.rentACarReCap.business.rules;

import org.springframework.stereotype.Service;

import hardworking.io.rentACarReCap.core.utilities.exceptions.BusinessException;
import hardworking.io.rentACarReCap.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@Data
@AllArgsConstructor
public class BrandBusinessRules {
	private BrandRepository _brandRepository;

	public void checkIfBrandNameExist(String name) {
		if(_brandRepository.existsByName(name)) {
			
			/*
			 1- Burada hatayı yakalıyoruz bunu fırlatıyoruz ve bu hatayı "main" metodu içerisinde yakalayacağız.
			 2- Normalde AAA alanındaki gibi RuntimeException yazılabilir ancak biz göndereceğizmi exception'u
			   özelleştirmek istiyoruz o yüzden BBB alanındaki gibi yazıldı.
			 3- ExceptionHandling bütün projeyi ilgilendirdiği için "core.utilities.exceptions" klasörünün altına
			   yazıldı.
			 
			 4- İş kurallarımızı "<X>Manager" sınfıları içerisine kullanacağız bu yüzden o sınıflara inject 
			   yapılmalıdır.
			
					throw new RuntimeException("Brand already exists");   //AAA

			 */ 
			
			
			throw new BusinessException("Brand name already exists");  // BBB
		}
	}
}
