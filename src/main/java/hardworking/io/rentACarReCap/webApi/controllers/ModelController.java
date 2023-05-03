package hardworking.io.rentACarReCap.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hardworking.io.rentACarReCap.business.abstracts.ModelService;
import hardworking.io.rentACarReCap.business.dtos.requests.CreateModelRequest;
import hardworking.io.rentACarReCap.business.dtos.requests.ProcessByIdModelRequest;
import hardworking.io.rentACarReCap.business.dtos.requests.UpdateModelRequest;
import hardworking.io.rentACarReCap.business.dtos.responses.CreateModelResponse;
import hardworking.io.rentACarReCap.business.dtos.responses.GetAllModelsResponse;
import hardworking.io.rentACarReCap.business.dtos.responses.GetDefaultModelResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/models/")
@AllArgsConstructor
public class ModelController {
	private ModelService _modelService;

	@GetMapping("getAll")
	public List<GetAllModelsResponse> getAll() {
		return _modelService.getAll();
	}
	
	@GetMapping("getById")
	GetDefaultModelResponse getById(int id) {
		return _modelService.getById(id);
	}
	
	@GetMapping("getByName")
	GetDefaultModelResponse getByName(String name) {
		return _modelService.getByName(name);
	}
	
	@PostMapping("add")
	public CreateModelResponse add(CreateModelRequest createModelRequest) {
		return _modelService.add(createModelRequest);
	}
	
	@PutMapping("update")
	void update(UpdateModelRequest updateModelRequest) {
		_modelService.update(updateModelRequest);
	}
	
	@DeleteMapping("deleteById")
	void deleteById(int id) {
		_modelService.deleteById(id);
	}
	
	@DeleteMapping("delete")
	void delete(ProcessByIdModelRequest processByIdModelRequest)
	{
		_modelService.delete(processByIdModelRequest);	
	}

}
