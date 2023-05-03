package hardworking.io.rentACarReCap.business.abstracts;

import java.util.List;

import hardworking.io.rentACarReCap.business.dtos.requests.CreateModelRequest;
import hardworking.io.rentACarReCap.business.dtos.requests.ProcessByIdModelRequest;
import hardworking.io.rentACarReCap.business.dtos.requests.UpdateModelRequest;
import hardworking.io.rentACarReCap.business.dtos.responses.CreateModelResponse;
import hardworking.io.rentACarReCap.business.dtos.responses.GetAllModelsResponse;
import hardworking.io.rentACarReCap.business.dtos.responses.GetDefaultModelResponse;

public interface ModelService {
	
	List<GetAllModelsResponse> getAll();
	GetDefaultModelResponse getById(int id);
	GetDefaultModelResponse getByName(String name);
	CreateModelResponse add(CreateModelRequest createModelRequest);
	void update(UpdateModelRequest updateModelRequest);
	void deleteById(int id);
	void delete(ProcessByIdModelRequest processByIdModelRequest);
}
