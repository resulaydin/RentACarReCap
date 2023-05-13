package hardworking.io.rentACarReCap.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import hardworking.io.rentACarReCap.business.dtos.requests.CreateCarRequest;
import hardworking.io.rentACarReCap.business.dtos.responses.GetAllCarsResponse;

@Service
public interface CarService {
	
	List<GetAllCarsResponse> getAll();
	void add(CreateCarRequest createCarRequest); 
}
