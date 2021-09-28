package com.cst438.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EnrollmentRepository extends CrudRepository <Enrollment, Integer> {

}
