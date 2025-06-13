package in.ashokit.binding;



import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "COURSE")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;
	private String name;
	private Double price;
	private Integer duration;

}
