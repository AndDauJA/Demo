package lt.daujotas.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "size")
public class Size {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @jakarta.validation.constraints.Size(max = 255)
    @Column(name = "value")
    private String value;

    @jakarta.validation.constraints.Size(max = 255)
    @Column(name = "measure_id")
    private String measureId;

}