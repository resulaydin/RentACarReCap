package hardworking.io.rentACarReCap.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import hardworking.io.rentACarReCap.business.abstracts.BrandService;
import hardworking.io.rentACarReCap.business.dtos.requests.CreateBrandRequest;
import hardworking.io.rentACarReCap.business.dtos.requests.ProcessByIdBrandRequest;
import hardworking.io.rentACarReCap.business.dtos.requests.UpdateBrandRequest;
import hardworking.io.rentACarReCap.business.dtos.responses.GetAllBrandsResponse;
import hardworking.io.rentACarReCap.business.dtos.responses.GetDefaultBrandResponse;
import hardworking.io.rentACarReCap.business.rules.BrandBusinessRules;
import hardworking.io.rentACarReCap.core.utilities.mappers.ModelMapperService;
import hardworking.io.rentACarReCap.dataAccess.abstracts.BrandRepository;
import hardworking.io.rentACarReCap.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
	private BrandRepository _brandBrandRepository;
	private ModelMapperService _modelMapperService;
	private BrandBusinessRules _businessExceptionRules;


	@Override
	public List<GetAllBrandsResponse> getAll() {

		List<Brand> brands = _brandBrandRepository.findAll();

		List<GetAllBrandsResponse> brandsResponses = brands.stream()
				.map(brand -> _modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class))
				.collect(Collectors.toList());

		return brandsResponses;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {

		// Buraya kuralımızı yazdık ve gerekli check yaptık.
		// Bu şekilde if - else hell kurtulduk.
		_businessExceptionRules.checkIfBrandNameExist(createBrandRequest.getName());
		
		Brand brandRequest = _modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		_brandBrandRepository.save(brandRequest);

	}

	@Override
	public void deleteById(int id) {
		_brandBrandRepository.deleteById(id);

	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
//// 1. Yöntem
//		Brand brand = _brandBrandRepository
//				.findById(_modelMapperService.forRequest().map(updateBrandRequest, Brand.class).getId()).orElseThrow();
//		brand.setName(updateBrandRequest.getName());

		// 2. Yöntem
		Brand brand = _modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		_brandBrandRepository.save(brand);

	}

	@Override
	public void delete(ProcessByIdBrandRequest processByIdBrandRequest) {
		_brandBrandRepository.delete(_modelMapperService.forRequest().map(processByIdBrandRequest, Brand.class));
	}

	@Override
	public GetDefaultBrandResponse getById(ProcessByIdBrandRequest processByIdBrandRequest) {
		Brand brand = _brandBrandRepository.findById(processByIdBrandRequest.getId()).orElseThrow();
		return _modelMapperService.forResponse().map(brand, GetDefaultBrandResponse.class);
	}

	@Override
	public GetDefaultBrandResponse getByName(String name) {
		GetDefaultBrandResponse brandResponse = _modelMapperService.forResponse()
				.map(_brandBrandRepository.findBrandByName(name), GetDefaultBrandResponse.class);
		return brandResponse;
	}
}
