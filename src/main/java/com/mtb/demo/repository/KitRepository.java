package com.mtb.demo.repository;

import com.mtb.demo.entity.Kit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KitRepository extends JpaRepository<Kit, Long> {

}
