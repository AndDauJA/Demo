package com.mtb.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "d_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Product extends Auditable {

	@Size(max = 255)
	private String sku;

	@Size(max = 255)
	private String name;

	@Size(max = 255)
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	private Brand brand;

	@ManyToOne(fetch = FetchType.LAZY)
	private Vendor vendor;

	@ManyToOne(fetch = FetchType.LAZY)
	private Type type;

	@Column(precision = 10)
	private BigDecimal price;

	@ManyToOne(fetch = FetchType.LAZY)
	private Currency currency;

	private int ratingValue;

	@Builder.Default
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "product_colors",
			   joinColumns = @JoinColumn(name = "product_id"),
			   inverseJoinColumns = @JoinColumn(name = "color_id"))
	private Set<Color> productColors = new LinkedHashSet<>();

	@Builder.Default
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "product_genders",
			   joinColumns = @JoinColumn(name = "product_id"),
			   inverseJoinColumns = @JoinColumn(name = "gender_id"))
	private Set<com.mtb.demo.entity.Gender> productGenders = new LinkedHashSet<>();

	@Builder.Default
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "product_sizes",
			   joinColumns = @JoinColumn(name = "product_id"),
			   inverseJoinColumns = @JoinColumn(name = "size_id"))
	private Set<com.mtb.demo.entity.Size> productSizes = new LinkedHashSet<>();
}
