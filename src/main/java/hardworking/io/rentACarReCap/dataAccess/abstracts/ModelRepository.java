package hardworking.io.rentACarReCap.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hardworking.io.rentACarReCap.entities.concretes.Model;

public interface  ModelRepository extends JpaRepository<Model, Integer> {
	Model findByName(String name);
}
