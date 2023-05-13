package hardworking.io.rentACarReCap.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hardworking.io.rentACarReCap.business.abstracts.CarService;
import hardworking.io.rentACarReCap.business.dtos.requests.CreateCarRequest;
import hardworking.io.rentACarReCap.business.dtos.responses.GetAllCarsResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/")
@AllArgsConstructor
public class CarsController {

	private CarService _carService;

	@GetMapping("getAll")
	public List<GetAllCarsResponse> getAll() {
		return _carService.getAll();
	}
	
	@PostMapping("add")
	public void add(CreateCarRequest createCarRequest) {
		_carService.add(createCarRequest);
	}

}
