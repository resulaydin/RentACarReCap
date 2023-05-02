package hardworking.io.rentACarReCap.business.abstracts;

import java.util.List;

import hardworking.io.rentACarReCap.business.dtos.responses.GetAllBrandsResponse;

public interface BrandService {
	
	List<GetAllBrandsResponse> getAll();

}
