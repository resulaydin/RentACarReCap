package hardworking.io.rentACarReCap.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import hardworking.io.rentACarReCap.business.abstracts.CarService;
import hardworking.io.rentACarReCap.business.dtos.requests.CreateCarRequest;
import hardworking.io.rentACarReCap.business.dtos.responses.GetAllCarsResponse;
import hardworking.io.rentACarReCap.core.utilities.mappers.ModelMapperService;
import hardworking.io.rentACarReCap.dataAccess.abstracts.CarRepository;
import hardworking.io.rentACarReCap.entities.concretes.Car;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarManager implements CarService {

	private CarRepository _carRepository;
	private ModelMapperService _modelMapperService;

	@Override
	public List<GetAllCarsResponse> getAll() {

		List<Car> cars = _carRepository.findAll();
		return cars.stream().map(car -> _modelMapperService.forResponse().map(car, GetAllCarsResponse.class))
				.collect(Collectors.toList());
	}

	@Override
	public void add(CreateCarRequest createCarRequest) {
		_carRepository.save(_modelMapperService.forRequest().map(createCarRequest, Car.class));
//		System.out.println(car.getModel().getBrand().getName());
	}

}
