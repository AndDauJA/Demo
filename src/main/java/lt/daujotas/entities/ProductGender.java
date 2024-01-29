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
@Table(name = "product_genders")
public class ProductGender {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "gender_id")
    private Integer genderId;

}