package lt.daujotas.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "product")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 255)
    @Column(name = "sku")
    private String sku;

    @Size(max = 255)
    @Column(name = "name")
    private String name;

    @Size(max = 255)
    @Column(name = "description")
    private String description;

    @Column(name = "brand_id")
    private Integer brandId;

    @Column(name = "vendor_id")
    private Integer vendorId;

    @Column(name = "type_id")
    private Integer typeId;

    @Column(name = "price", precision = 10)
    private BigDecimal price;

    @Column(name = "currency_id")
    private Integer currencyId;

    @Column(name = "rating_value")
    private Integer ratingValue;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}