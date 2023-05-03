package hardworking.io.rentACarReCap.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import hardworking.io.rentACarReCap.business.abstracts.ModelService;
import hardworking.io.rentACarReCap.business.dtos.requests.CreateModelRequest;
import hardworking.io.rentACarReCap.business.dtos.requests.ProcessByIdModelRequest;
import hardworking.io.rentACarReCap.business.dtos.requests.UpdateModelRequest;
import hardworking.io.rentACarReCap.business.dtos.responses.CreateModelResponse;
import hardworking.io.rentACarReCap.business.dtos.responses.GetAllModelsResponse;
import hardworking.io.rentACarReCap.business.dtos.responses.GetDefaultModelResponse;
import hardworking.io.rentACarReCap.core.utilities.mappers.ModelMapperService;
import hardworking.io.rentACarReCap.dataAccess.abstracts.ModelRepository;
import hardworking.io.rentACarReCap.entities.concretes.Model;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
	private ModelRepository _modelRepository;
	private ModelMapperService _modelMapperService;

	@Override
	public List<GetAllModelsResponse> getAll() {
		List<Model> models = _modelRepository.findAll();
		return models.stream().map(model -> _modelMapperService.forResponse().map(model, GetAllModelsResponse.class))
				.collect(Collectors.toList());
	}

	@Override
	public CreateModelResponse add(CreateModelRequest createModelRequest) {
		Model model = _modelMapperService.forRequest().map(createModelRequest, Model.class);
		Model modelResponse = _modelRepository.save(model);
		return _modelMapperService.forResponse().map(modelResponse, CreateModelResponse.class);
	}

	@Override
	public GetDefaultModelResponse getById(int id) {

		return _modelMapperService.forResponse().map(_modelRepository.findById(id), GetDefaultModelResponse.class);
	}

	@Override
	public GetDefaultModelResponse getByName(String name) {

		return _modelMapperService.forResponse().map(_modelRepository.findByName(name), GetDefaultModelResponse.class);
	}

	@Override
	public void update(UpdateModelRequest updateModelRequest) {
		Model model = _modelRepository.findById(updateModelRequest.getId()).orElseThrow();
		model.setName(updateModelRequest.getName());
		model.getBrand().setName(updateModelRequest.getBrandName());
		_modelRepository.save(model);

	}

	@Override
	public void deleteById(int id) {
		_modelRepository.deleteById(id);
	}

	@Override
	public void delete(ProcessByIdModelRequest processByIdModelRequest) {
		_modelRepository.delete(_modelMapperService.forRequest()
				.map(processByIdModelRequest, Model.class));
	}

}
