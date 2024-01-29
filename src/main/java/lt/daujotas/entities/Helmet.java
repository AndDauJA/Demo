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
@Table(name = "helmet")
public class Helmet {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "helmet_type_id")
    private Integer helmetTypeId;

}