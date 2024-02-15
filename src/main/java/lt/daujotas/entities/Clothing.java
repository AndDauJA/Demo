package lt.daujotas.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "clothings")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Clothing {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 10)
    @Column(name = "gender")
    private String gender;

    @Size(max = 5)
    @Column(name = "size")
    private String size;

    @Size(max = 15)
    @Column(name = "color")
    private String color;

    @Size(max = 255)
    @Column(name = "brand")
    private String brand;

//    @Column(name = "brand_id")
//    private Integer brandId;
//
//    @Column(name = "vendor_id")
//    private Integer vendorId;
//
//    @Column(name = "type_id")
//    private Integer typeId;
//
//    @Column(name = "price", precision = 10)
//    private BigDecimal price;

//    @Column(name = "currency_id")
//    private Integer currencyId;
//
//    @Column(name = "rating_value")
//    private Integer ratingValue;
//
//    @Column(name = "created_at")
//    private Instant createdAt;
//
//    @Column(name = "updated_at")
//    private Instant updatedAt;


}
