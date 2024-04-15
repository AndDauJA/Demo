package com.mtb.demo.repository;


import java.util.Optional;
import java.util.Set;

import com.mtb.demo.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender, Long> {

	Optional<Gender> findByCode (String code);
}
