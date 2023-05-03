package hardworking.io.rentACarReCap.business.abstracts;

import java.util.List;

import hardworking.io.rentACarReCap.business.dtos.requests.CreateBrandRequest;
import hardworking.io.rentACarReCap.business.dtos.requests.ProcessByIdBrandRequest;
import hardworking.io.rentACarReCap.business.dtos.requests.UpdateBrandRequest;
import hardworking.io.rentACarReCap.business.dtos.responses.GetAllBrandsResponse;
import hardworking.io.rentACarReCap.business.dtos.responses.GetDefaultBrandResponse;

public interface BrandService {
	
	List<GetAllBrandsResponse> getAll();
	void update(UpdateBrandRequest updateBrandRequest);
	void add(CreateBrandRequest createBrandRequest);
	void deleteById(int id);
	void delete(ProcessByIdBrandRequest processByIdBrandRequest);
	GetDefaultBrandResponse getById(ProcessByIdBrandRequest processByIdBrandRequest);
	GetDefaultBrandResponse  getByName(String name);
	
}
