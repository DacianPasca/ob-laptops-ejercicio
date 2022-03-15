package com.obspring.obh2jpawebdevtools.repository;

import com.obspring.obh2jpawebdevtools.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
