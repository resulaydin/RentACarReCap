package hardworking.io.rentACarReCap.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hardworking.io.rentACarReCap.business.abstracts.BrandService;
import hardworking.io.rentACarReCap.business.dtos.requests.CreateBrandRequest;
import hardworking.io.rentACarReCap.business.dtos.responses.GetAllBrandsResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/brands/")
@AllArgsConstructor
public class BrandsController {
	private BrandService _brandService;
	
	@GetMapping("getAll")
	public List<GetAllBrandsResponse> getAll(){
		return _brandService.getAll();
	}
	
	@PostMapping("add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(CreateBrandRequest createBrandRequest) {
		_brandService.add(createBrandRequest);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public void deleteById(int id) {
		_brandService.deleteById(id);
	}

}
