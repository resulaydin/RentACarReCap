package hardworking.io.rentACarReCap.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import hardworking.io.rentACarReCap.entities.concretes.Brand;

public interface BrandRepository extends JpaRepository<Brand,Integer>{

}
