package hardworking.io.rentACarReCap.business.abstracts;

import java.util.List;

import hardworking.io.rentACarReCap.business.dtos.requests.CreateBrandRequest;
import hardworking.io.rentACarReCap.business.dtos.responses.GetAllBrandsResponse;

public interface BrandService {
	
	List<GetAllBrandsResponse> getAll();
	void add(CreateBrandRequest createBrandRequest);
	void deleteById(int id);

}
