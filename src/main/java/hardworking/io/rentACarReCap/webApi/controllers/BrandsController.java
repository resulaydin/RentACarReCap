package hardworking.io.rentACarReCap.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hardworking.io.rentACarReCap.business.abstracts.BrandService;
import hardworking.io.rentACarReCap.business.dtos.requests.CreateBrandRequest;
import hardworking.io.rentACarReCap.business.dtos.requests.ProcessByIdBrandRequest;
import hardworking.io.rentACarReCap.business.dtos.requests.UpdateBrandRequest;
import hardworking.io.rentACarReCap.business.dtos.responses.GetAllBrandsResponse;
import hardworking.io.rentACarReCap.business.dtos.responses.GetDefaultBrandResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/brands/")
@AllArgsConstructor
public class BrandsController {
	private BrandService _brandService;

	@GetMapping()
	public List<GetAllBrandsResponse> getAll() {
		return _brandService.getAll();
	}

	@GetMapping("getById")
	GetDefaultBrandResponse getById(@RequestBody ProcessByIdBrandRequest processByIdBrandRequest) {
		return _brandService.getById(processByIdBrandRequest);
	}

	@GetMapping("/{name}")
	GetDefaultBrandResponse getByName(@PathVariable String name) {
		return _brandService.getByName(name);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() @Valid() CreateBrandRequest createBrandRequest) {
		_brandService.add(createBrandRequest);
	}

	@PutMapping
	void update(@RequestBody() UpdateBrandRequest updateBrandRequest) {
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
