package lt.daujotas.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product_images")
public class ProductImage {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "product_id")
    private Integer productId;

    @Size(max = 255)
    @Column(name = "image_path")
    private String imagePath;

}