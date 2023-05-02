package hardworking.io.rentACarReCap.core.utilities.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService {
	private ModelMapper _modelMapper;

	@Override
	public ModelMapper forRequest() {
		_modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STANDARD);
		return _modelMapper;
	}

	@Override
	public ModelMapper forResponse() {
		_modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
		return _modelMapper;
	}

	/*
	 * this.modelMapper.getConfiguration() .setAmbiguityIgnored(true)
	 * .setMatchingStrategy(MatchingStrategies.LOOSE); return this.modelMapper;
	 */

}
