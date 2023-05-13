package hardworking.io.rentACarReCap.business.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {

	@NotNull
	@NotBlank
	@Size(min = 3, max = 20)
	private String plate;
	@NotNull
	@NotBlank
	private double dailyPrice;
	@NotNull
	@NotBlank
	private int modelYear;
	@NotNull
	@NotBlank
	private int state;
	@NotNull
	@NotBlank
	private int modelId;
	

}
