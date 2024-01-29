package lt.daujotas.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "vendor")
public class Vendor {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 255)
    @Column(name = "url")
    private String url;

    @Size(max = 255)
    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "description")
    private String description;

}