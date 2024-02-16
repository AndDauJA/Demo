package com.mtb.demo.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Bike extends Product {

	@ManyToOne(fetch = FetchType.LAZY)
	private BikeFrame frame;

	@Builder.Default
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "product_bike_frames",
			   joinColumns = @JoinColumn(name = "product_id"),
			   inverseJoinColumns = @JoinColumn(name = "bike_frame_id"))
	private Set<BikeFrame> bikeFrames = new LinkedHashSet<>();
}
