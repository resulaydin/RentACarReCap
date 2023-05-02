package hardworking.io.rentACarReCap.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hardworking.io.rentACarReCap.business.abstracts.BrandService;
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

}
