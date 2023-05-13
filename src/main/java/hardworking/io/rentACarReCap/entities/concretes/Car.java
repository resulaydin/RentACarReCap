package hardworking.io.rentACarReCap.entities.concretes;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "cars")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "plate")
	private String plate;
	@Column(name = "dailyPrice")
	private double dailyPrice;
	@Column(name = "modelYear")
	private int modelYear;
	@Column(name = "state")
	private int state; // 1- Available, 2- Rented, 3- Maintenance
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "model_id")
	private Model model;

}
