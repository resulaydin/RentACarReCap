package hardworking.io.rentACarReCap.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hardworking.io.rentACarReCap.entities.concretes.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {

}
