package com.docker.test.docker_test_be.repository;

import com.docker.test.docker_test_be.entity.Calc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CalcRepository extends JpaRepository<Calc, Integer> {

}
