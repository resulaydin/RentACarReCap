package hardworking.io.rentACarReCap.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import hardworking.io.rentACarReCap.entities.concretes.Brand;

public interface BrandRepository extends JpaRepository<Brand,Integer>{
	Brand findBrandByName(String name);
	boolean existsByName(String name);
//	Brand existsByName(String name);
//	Spring JPA Keywords
	/*
	 
	 	- burada Spring JPA başta buluanan keyword ile bir if oluşturuyor ve BY' dan sonrakiler ise if
	 	  bloğunun şartları olmaktadır.
	 	  	* Eğer birden fazla sonuç dönecekse 	List<X>, 
	 	  	* Tekil sonuç olacaksa 					X
	 	  	* True,False olacaksa 					boolean
	 	  	* 
	 	- <exists> yazılıdığında sonucun boolean olacağı
	 	- <find>   yazıldığında ise sonucun nesne olacağı incelensin.
	 	
	 	  yazılmalıdır.
	 	
	 
	 */
}
