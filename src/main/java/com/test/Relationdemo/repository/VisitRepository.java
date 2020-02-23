package com.test.Relationdemo.repository;

import com.test.Relationdemo.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository  extends JpaRepository<Visit,Long> {
}
