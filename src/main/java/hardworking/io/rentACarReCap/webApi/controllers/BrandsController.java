package hardworking.io.rentACarReCap.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hardworking.io.rentACarReCap.business.abstracts.BrandService;
import hardworking.io.rentACarReCap.business.dtos.requests.CreateBrandRequest;
import hardworking.io.rentACarReCap.business.dtos.requests.ProcessByIdBrandRequest;
import hardworking.io.rentACarReCap.business.dtos.requests.UpdateBrandRequest;
import hardworking.io.rentACarReCap.business.dtos.responses.GetAllBrandsResponse;
import hardworking.io.rentACarReCap.business.dtos.responses.GetDefaultBrandResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/brands/")
@AllArgsConstructor
public class BrandsController {
	private BrandService _brandService;

	@GetMapping("getAll")
	public List<GetAllBrandsResponse> getAll() {
		return _brandService.getAll();
	}

	@GetMapping("getById")
	GetDefaultBrandResponse getById(@RequestBody ProcessByIdBrandRequest processByIdBrandRequest) {
		return _brandService.getById(processByIdBrandRequest);
	}

	@GetMapping("getByName")
	GetDefaultBrandResponse getByName(String name) {
		return _brandService.getByName(name);
	}

	@PostMapping("add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(CreateBrandRequest createBrandRequest) {
		_brandService.add(createBrandRequest);
	}

	@PutMapping("update")
	void update(UpdateBrandRequest updateBrandRequest) {
		_brandService.update(updateBrandRequest);
	}

	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteById(int id) {
		_brandService.deleteById(id);
	}

	@DeleteMapping()
	@ResponseStatus(code = HttpStatus.OK)
	public void delete(@RequestBody ProcessByIdBrandRequest processByIdBrandRequest) {
		_brandService.delete(processByIdBrandRequest);

	}

}
