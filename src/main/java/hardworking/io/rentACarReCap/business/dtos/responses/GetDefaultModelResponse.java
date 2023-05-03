package hardworking.io.rentACarReCap.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetDefaultModelResponse {

	private int id;
	private String name;
	private String brandName;

}
