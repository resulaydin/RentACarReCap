package hardworking.io.rentACarReCap.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCarsResponse {

	private String plate;
	private double dailyPrice;
	private int modelYear;
	private int state;
	private String modelName;
	private String modelBrandName;
}
