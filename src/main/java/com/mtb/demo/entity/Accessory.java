package com.mtb.demo.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Accessory extends Product{

	@Size(max = 255)
	private String note;

}
