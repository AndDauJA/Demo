package com.mtb.demo.repository;

import java.util.Collection;
import java.util.Set;

import com.mtb.demo.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender, Long> {

	Set<Gender> findDistinctByCodeIn(Collection<String> codes);
}
