package com.mtb.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Size {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@jakarta.validation.constraints.Size(max = 255)
	private String value;

	@ManyToOne(fetch = FetchType.LAZY)
	private Measure measure;

}
