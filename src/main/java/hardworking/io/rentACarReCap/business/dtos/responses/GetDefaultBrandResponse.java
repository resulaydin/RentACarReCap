package hardworking.io.rentACarReCap.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetDefaultBrandResponse {
	private int id;
	private String name;
}
