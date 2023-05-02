package hardworking.io.rentACarReCap.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import hardworking.io.rentACarReCap.business.abstracts.BrandService;
import hardworking.io.rentACarReCap.business.dtos.responses.GetAllBrandsResponse;
import hardworking.io.rentACarReCap.core.utilities.mappers.ModelMapperService;
import hardworking.io.rentACarReCap.dataAccess.abstracts.BrandRepository;
import hardworking.io.rentACarReCap.entities.concretes.Brand;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
	private BrandRepository _brandBrandRepository;
	private ModelMapperService _modelMapperService;

	@Override
	public List<GetAllBrandsResponse> getAll() {
		
		List<Brand> brands=_brandBrandRepository.findAll();
		
		List<GetAllBrandsResponse> brandsResponses= brands.stream()
				.map(brand->_modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class))
				.collect(Collectors.toList());
		
		return brandsResponses;
	}

	
	/*		List<GetAllBrandsResponse> brandsResponses = brands.stream()
				.map(brand -> _modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class))
				.collect(Collectors.toList());
		return brandsResponses;
	 * 
	 * */
}
